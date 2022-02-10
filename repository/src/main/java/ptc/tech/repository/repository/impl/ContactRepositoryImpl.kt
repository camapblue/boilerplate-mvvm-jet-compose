package ptc.tech.repository.repository.impl

import ptc.tech.repository.api.ContactApi
import ptc.tech.repository.model.Contact
import ptc.tech.repository.repository.ContactRepository

class ContactRepositoryImpl(
    private val contactApi: ContactApi
): ContactRepository {

    override suspend fun fetchContacts(): Array<Contact> {
        return contactApi.fetchContacts()
    }

    override suspend fun editContact(contact: Contact): Contact {
        return contact
    }
}