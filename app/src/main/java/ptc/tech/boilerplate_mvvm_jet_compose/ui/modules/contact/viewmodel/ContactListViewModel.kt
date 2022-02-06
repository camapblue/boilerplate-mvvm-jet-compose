package ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ptc.tech.repository.model.Contact
import ptc.tech.boilerplate_mvvm_jet_compose.use_case.GetContactsUseCase

class ContactListViewModel(
    private val getContactsUseCase: GetContactsUseCase
): ViewModel() {
    var loading by mutableStateOf(false)

    var contacts by mutableStateOf(arrayOf<Contact>())

    fun fetchContacts() {
        viewModelScope.launch(Dispatchers.Main) {
            loading = true
            try {
                contacts = withContext(Dispatchers.IO) { getContactsUseCase.fetchContacts() }
                loading = false
            } catch (exception: Exception) {
                println("Error = $exception")
            }
        }
    }
}