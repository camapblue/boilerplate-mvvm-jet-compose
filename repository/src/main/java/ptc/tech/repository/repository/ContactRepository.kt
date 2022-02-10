package ptc.tech.repository.repository

import ptc.tech.repository.model.Contact

interface ContactRepository {
    suspend fun fetchContacts(): Array<Contact>

    suspend fun editContact(contact: Contact): Contact
}