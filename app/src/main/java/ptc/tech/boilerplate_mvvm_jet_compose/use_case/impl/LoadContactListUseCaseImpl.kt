package ptc.tech.boilerplate_mvvm_jet_compose.use_case.impl

import ptc.tech.boilerplate_mvvm_jet_compose.app_state.ContactManager
import ptc.tech.repository.model.Contact
import ptc.tech.boilerplate_mvvm_jet_compose.use_case.LoadListUseCase
import ptc.tech.repository.repository.ContactRepository

class LoadContactListUseCaseImpl(
    private var contactManager: ContactManager,
    private val contactRepository: ContactRepository
): LoadListUseCase<Contact>() {
    override suspend fun loadItems(): Array<Contact> {
        val contacts = contactRepository.fetchContacts()
        contactManager.updateContactList(contacts = contacts)
        return contacts
    }
}
