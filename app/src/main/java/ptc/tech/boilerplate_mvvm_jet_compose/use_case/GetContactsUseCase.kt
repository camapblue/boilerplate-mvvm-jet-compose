package ptc.tech.boilerplate_mvvm_jet_compose.use_case

import ptc.tech.repository.model.Contact

interface GetContactsUseCase {
    fun fetchContacts(): Array<Contact>
}