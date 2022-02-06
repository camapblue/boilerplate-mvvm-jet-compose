package ptc.tech.boilerplate_mvvm_jet_compose.use_case.impl

import ptc.tech.repository.model.Contact
import ptc.tech.boilerplate_mvvm_jet_compose.use_case.GetContactsUseCase
import ptc.tech.repository.repository.ContactRepository
import kotlin.properties.Delegates

class GetContactsUseCaseImpl: GetContactsUseCase {
    private var contactRepository: ContactRepository by Delegates.notNull()

    constructor(contactRepository: ContactRepository) {
        this.contactRepository = contactRepository
    }

    override fun fetchContacts(): Array<Contact> {
        return contactRepository.fetchContacts()
    }
}