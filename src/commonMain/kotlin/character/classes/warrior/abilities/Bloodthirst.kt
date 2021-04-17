package character.classes.warrior.abilities

import character.Ability
import character.Proc
import character.Resource
import character.classes.warrior.talents.Bloodthirst as BloodthirstTalent
import data.Constants
import data.itemsets.DestroyerBattlegear
import data.itemsets.OnslaughtBattlegear
import mechanics.Melee
import sim.Event
import sim.SimParticipant

class Bloodthirst : Ability() {
    companion object {
        const val name: String = "Bloodthirst"
    }

    override val id: Int = 30335
    override val name: String = Companion.name

    override fun cooldownMs(sp: SimParticipant): Int = 6000
    override fun gcdMs(sp: SimParticipant): Int = sp.physicalGcd().toInt()

    override fun resourceType(sp: SimParticipant): Resource.Type = Resource.Type.RAGE
    override fun resourceCost(sp: SimParticipant): Double {
        val baseCost = 30.0

        // Check T5 set bonus
        val t5Bonus = sp.buffs[DestroyerBattlegear.FOUR_SET_BUFF_NAME] != null
        val t5CostReduction = if(t5Bonus) { DestroyerBattlegear.fourSetBTMSCostReduction() } else 0.0

        return baseCost - t5CostReduction
    }

    override fun available(sp: SimParticipant): Boolean {
        return sp.character.klass.talents[BloodthirstTalent.name]?.currentRank == 1 && super.available(sp)
    }

    override fun cast(sp: SimParticipant) {
        // TODO: This currently assigns the main hand weapon as context,
        //       since that would allow things like Sword Spec to proc off of BT, which I presume it can
        val item = sp.character.gear.mainHand

        // Check T6 set bonus
        val t6Bonus = sp.buffs[OnslaughtBattlegear.FOUR_SET_BUFF_NAME] != null
        val t6Multiplier = if(t6Bonus) { OnslaughtBattlegear.fourSetMSBTDamageMultiplier() } else 1.0

        val damage = sp.attackPower() * 0.45 * t6Multiplier
        val result = Melee.attackRoll(sp, damage, item, isWhiteDmg = false)

        // Save last hit state and fire event
        val event = Event(
            eventType = Event.Type.DAMAGE,
            damageType = Constants.DamageType.PHYSICAL,
            abilityName = name,
            amount = result.first,
            result = result.second,
        )
        sp.logEvent(event)

        // Proc anything that can proc off a yellow hit
        val triggerTypes = when(result.second) {
            Event.Result.HIT -> listOf(Proc.Trigger.MELEE_YELLOW_HIT, Proc.Trigger.PHYSICAL_DAMAGE)
            Event.Result.CRIT -> listOf(Proc.Trigger.MELEE_YELLOW_CRIT, Proc.Trigger.PHYSICAL_DAMAGE)
            Event.Result.MISS -> listOf(Proc.Trigger.MELEE_MISS)
            Event.Result.DODGE -> listOf(Proc.Trigger.MELEE_DODGE)
            Event.Result.PARRY -> listOf(Proc.Trigger.MELEE_PARRY)
            Event.Result.BLOCK -> listOf(Proc.Trigger.MELEE_YELLOW_HIT, Proc.Trigger.PHYSICAL_DAMAGE)
            Event.Result.BLOCKED_CRIT -> listOf(Proc.Trigger.MELEE_YELLOW_CRIT, Proc.Trigger.PHYSICAL_DAMAGE)
            else -> null
        }

        if(triggerTypes != null) {
            sp.fireProc(triggerTypes, listOf(item), this, event)
        }
    }
}