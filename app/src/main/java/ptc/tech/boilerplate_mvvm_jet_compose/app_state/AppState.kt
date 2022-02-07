package ptc.tech.boilerplate_mvvm_jet_compose.app_state

import ptc.tech.boilerplate_mvvm_jet_compose.app_state.impl.ContactManagerImpl

class AppState {
    companion object {
        val instance = AppState()
    }

    private lateinit var contactManagerInstance: ContactManager

    fun contactManager(): ContactManager {
        if (::contactManagerInstance.isInitialized) {
            return contactManagerInstance
        }
        contactManagerInstance = ContactManagerImpl()
        return contactManagerInstance
    }
}