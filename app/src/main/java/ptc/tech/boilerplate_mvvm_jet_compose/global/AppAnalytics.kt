package ptc.tech.boilerplate_mvvm_jet_compose.global

import ptc.tech.boilerplate_mvvm_jet_compose.models.Event

class AppAnalytics {
    companion object {
        val instance = AppAnalytics()
    }

    fun trackEvent(event: Event) {
        println("Log event ${event.event} value ${event.value}")
    }
}