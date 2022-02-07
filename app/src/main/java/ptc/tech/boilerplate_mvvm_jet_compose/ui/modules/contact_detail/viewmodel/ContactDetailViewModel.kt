package ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact_detail.viewmodel

import androidx.lifecycle.ViewModel
import ptc.tech.boilerplate_mvvm_jet_compose.app_state.ContactManager
import ptc.tech.repository.model.Contact

class ContactDetailViewModel(
    private val contactId: String,
    private val contactManager: ContactManager
): ViewModel() {
    fun getContact(): Contact? {
        return contactManager.getContactById(contactId)
    }

    fun contactId(): String {
        return contactId
    }
}