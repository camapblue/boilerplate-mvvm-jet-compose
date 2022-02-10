package ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact_detail.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import ptc.tech.boilerplate_mvvm_jet_compose.app_state.ContactManager
import ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.common.BaseViewModel
import ptc.tech.boilerplate_mvvm_jet_compose.use_case.EditContactUseCase
import ptc.tech.repository.model.Contact

class ContactDetailViewModel(
    private val contactId: String,
    private val contactManager: ContactManager,
    private val editContactUseCase: EditContactUseCase
): BaseViewModel() {
    var contact by mutableStateOf<Contact?>(null)

    fun loadContact() {
        contact = contactManager.getContactById(contactId)
    }

    fun contactId(): String {
        return contactId
    }

    fun editContact(firstName: String, lastName: String) {
        viewModelScope.launch(Dispatchers.Main) {
            val updatedContact = contact!!.copy(firstName = firstName, lastName = lastName)
            contact = updatedContact
            showGlobalLoading()
            try {
                contact = withContext(Dispatchers.IO) { editContactUseCase.editContact(
                    contact = updatedContact
                )}
                hideGlobalLoading()
            } catch (exception: Exception) {
                println("Error = $exception")
            }
        }
    }
}