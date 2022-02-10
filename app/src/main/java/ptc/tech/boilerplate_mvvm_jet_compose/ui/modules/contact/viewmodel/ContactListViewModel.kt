package ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ptc.tech.boilerplate_mvvm_jet_compose.app_state.ContactManager
import ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.common.LoadListViewModel
import ptc.tech.repository.model.Contact
import ptc.tech.boilerplate_mvvm_jet_compose.use_case.LoadListUseCase

class ContactListViewModel(
    loadListUseCase: LoadListUseCase<Contact>,
    private val contactManager: ContactManager
): LoadListViewModel<Contact>(
    loadListUseCase = loadListUseCase
) {
    override fun bindEvents() {
        viewModelScope.launch(Dispatchers.Main) {
            contactManager
                .contactListUpdated()
                .collect {
                    println("CONTACT LIST UPDATED")
                    updateItems(it)
                }
        }
    }
}