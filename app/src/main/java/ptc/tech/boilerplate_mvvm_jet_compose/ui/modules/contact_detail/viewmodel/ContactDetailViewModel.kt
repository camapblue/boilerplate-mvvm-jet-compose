package ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact_detail.viewmodel

import ptc.tech.boilerplate_mvvm_jet_compose.app_state.ContactManager
import ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.common.BaseViewModel
import ptc.tech.repository.model.Contact
import java.util.*
import kotlin.concurrent.schedule

class ContactDetailViewModel(
    private val contactId: String,
    private val contactManager: ContactManager
): BaseViewModel() {
    fun getContact(): Contact? {
        return contactManager.getContactById(contactId)
    }

    fun contactId(): String {
        return contactId
    }

    fun editContact() {
        showGlobalLoading()

        Timer().schedule(2000) {
            hideGlobalLoading()
        }
    }
}