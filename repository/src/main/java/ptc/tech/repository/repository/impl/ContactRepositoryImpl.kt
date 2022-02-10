package ptc.tech.repository.repository.impl

import ptc.tech.repository.api.ContactApi
import ptc.tech.repository.model.Contact
import ptc.tech.repository.repository.ContactRepository
import java.lang.Exception

class ContactRepositoryImpl(
    private val contactApi: ContactApi
): ContactRepository {

    override suspend fun fetchContacts(): Array<Contact> {
        return contactApi.fetchContacts()
    }

    override suspend fun editContact(contact: Contact): Contact {
        if (contact.firstName.length > 8) {
            throw Exception("First Name is too long")
        }
        return contact
    }
}