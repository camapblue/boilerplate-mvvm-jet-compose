package ptc.tech.repository.repository

import ptc.tech.repository.model.Contact

interface ContactRepository {
    fun fetchContacts(): Array<Contact>

    fun editContact(contact: Contact): Contact
}