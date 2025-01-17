package character.classes.warrior.talents

import character.Buff
import character.Stats
import character.Talent
import sim.SimParticipant

class Impale(currentRank: Int) : Talent(currentRank) {
    companion object {
        const val name = "Impale"
    }

    override val name: String = Companion.name
    override val maxRank: Int = 2

    val buff = object : Buff() {
        override val name: String = "Impale"
        override val durationMs: Int = -1
        override val hidden: Boolean = true

        override fun modifyStats(sp: SimParticipant): Stats {
            val multiplier = 1.0 + currentRank * 0.1
            return Stats(
                yellowDamageAddlCritMultiplier = multiplier,
                whiteDamageAddlCritMultiplier = multiplier
            )
        }
    }

    override fun buffs(sp: SimParticipant): List<Buff> = listOf(buff)
}
