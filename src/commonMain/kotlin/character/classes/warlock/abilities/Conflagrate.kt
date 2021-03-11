package character.classes.warlock.abilities

import character.Ability
import character.Proc
import character.classes.warlock.debuffs.ImmolateDot
import character.classes.warlock.talents.Cataclysm
import character.classes.warlock.talents.Conflagrate
import character.classes.warlock.talents.Devastation
import data.Constants
import mechanics.General
import mechanics.Spell
import sim.Event
import sim.SimIteration

class Conflagrate : Ability() {
    companion object {
        const val name = "Conflagrate"
    }

    override val id: Int = 32231
    override val name: String = Companion.name
    override fun gcdMs(sim: SimIteration): Int = sim.spellGcd().toInt()

    override fun cooldownMs(sim: SimIteration): Int = 10000

    override fun available(sim: SimIteration): Boolean {
        return sim.debuffs[ImmolateDot.name] != null && (sim.subject.klass.talents[Conflagrate.name]?.currentRank ?: 0) > 0
    }

    override fun resourceCost(sim: SimIteration): Double {
        val cataclysm = sim.subject.klass.talents[Cataclysm.name] as Cataclysm?
        val cataRed = cataclysm?.destructionCostReduction() ?: 0.0

        return General.resourceCostReduction(305.0, listOf(cataRed))
    }

    val baseDamage = Pair(579.0, 722.0)
    override fun cast(sim: SimIteration) {
        val devastation = sim.subject.klass.talents[Devastation.name] as Devastation?
        val devastationAddlCrit = devastation?.additionalDestructionCritChance() ?: 0.0

        val spellPowerCoeff = Spell.spellPowerCoeff(0)
        val school = Constants.DamageType.FIRE

        val damageRoll = Spell.baseDamageRoll(sim, baseDamage.first, baseDamage.second, spellPowerCoeff, school)
        val result = Spell.attackRoll(sim, damageRoll, school, isBinary = false, devastationAddlCrit)

        val event = Event(
            eventType = Event.Type.DAMAGE,
            damageType = school,
            abilityName = name,
            amount = result.first,
            result = result.second,
        )
        sim.logEvent(event)

        // Remove the Immolate DoT
        sim.consumeDebuff(ImmolateDot())

        // Proc anything that can proc off non-periodic Fire damage
        val triggerTypes = when(result.second) {
            Event.Result.HIT -> listOf(Proc.Trigger.SPELL_HIT, Proc.Trigger.FIRE_DAMAGE)
            Event.Result.CRIT -> listOf(Proc.Trigger.SPELL_CRIT, Proc.Trigger.FIRE_DAMAGE)
            Event.Result.RESIST -> listOf(Proc.Trigger.SPELL_RESIST)
            Event.Result.PARTIAL_RESIST_HIT -> listOf(Proc.Trigger.SPELL_HIT, Proc.Trigger.FIRE_DAMAGE)
            Event.Result.PARTIAL_RESIST_CRIT -> listOf(Proc.Trigger.SPELL_CRIT, Proc.Trigger.FIRE_DAMAGE)
            else -> null
        }

        if(triggerTypes != null) {
            sim.fireProc(triggerTypes, listOf(), this, event)
        }
    }
}