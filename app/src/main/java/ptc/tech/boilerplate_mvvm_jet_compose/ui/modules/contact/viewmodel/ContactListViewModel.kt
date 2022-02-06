package ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact.viewmodel

import ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.common.LoadListViewModel
import ptc.tech.repository.model.Contact
import ptc.tech.boilerplate_mvvm_jet_compose.use_case.LoadListUseCase

class ContactListViewModel(
    loadListUseCase: LoadListUseCase<Contact>
): LoadListViewModel<Contact>(
    loadListUseCase = loadListUseCase
) {

}