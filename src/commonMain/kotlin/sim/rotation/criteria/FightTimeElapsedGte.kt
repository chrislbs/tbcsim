package sim.rotation.criteria

import sim.SimIteration
import sim.config.RotationRuleCriterion
import sim.rotation.Criterion

class FightTimeElapsedGte(data: RotationRuleCriterion) : Criterion(Type.FIGHT_TIME_ELAPSED_GTE, data) {
    val seconds: Double? = try {
        (data.seconds as Int).toDouble().coerceAtLeast(0.0)
    } catch (e: NullPointerException) {
        logger.warn { "Field 'seconds' is required for criterion $type" }
        null
    } catch(e: Exception) {
        logger.warn { "Field 'seconds' must be an integer for criterion $type" }
        null
    }

    override fun satisfied(sim: SimIteration): Boolean {
        return if(seconds == null) { false} else { sim.elapsedTimeMs >= seconds * 1000 }
    }
}