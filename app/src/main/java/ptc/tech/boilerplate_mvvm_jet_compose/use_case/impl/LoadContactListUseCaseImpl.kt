package ptc.tech.boilerplate_mvvm_jet_compose.use_case.impl

import ptc.tech.repository.model.Contact
import ptc.tech.boilerplate_mvvm_jet_compose.use_case.LoadListUseCase
import ptc.tech.repository.repository.ContactRepository

class LoadContactListUseCaseImpl(
    private val contactRepository: ContactRepository
): LoadListUseCase<Contact>() {
    override fun loadItems(): Array<Contact> {
        println("LOAD ITEMS NOW")
        return contactRepository.fetchContacts()
    }
}
