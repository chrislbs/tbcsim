import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import sim.Sim
import sim.SimIteration
import sim.SimOptions
import sim.SimProgress
import sim.config.Config
import kotlin.time.ExperimentalTime

@ExperimentalTime
@JsExport
fun runSim(config: Config, opts: SimOptions, progressCb: (SimProgress) -> Unit, cb: (iterations: Array<SimIteration>) -> Unit) {
    GlobalScope.promise {
        val iterations = Sim(config, opts, progressCb).sim()
        println("Done!")
        cb(iterations.toTypedArray())
    }
}
