package ptc.tech.boilerplate_mvvm_jet_compose.global

import ptc.tech.boilerplate_mvvm_jet_compose.models.Event
import java.lang.Exception

class AnalyticSystem {
    fun record() {}
}

class AppAnalytics(
    private val analyticSystem: AnalyticSystem = AnalyticSystem()
) {
    companion object {
        val instance = AppAnalytics()
    }

    fun trackAction(action: String) {
        println("Log action $action")
        analyticSystem.record()
    }

    fun trackEvent(event: Event) {
        println("Log event ${event.event} value ${event.value}")
        analyticSystem.record()
    }

    fun trackError(e: Exception) {
        println("Log exception ${e.localizedMessage}")
        analyticSystem.record()
    }
}