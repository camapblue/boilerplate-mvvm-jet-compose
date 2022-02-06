package ptc.tech.repository.api

import ptc.tech.repository.model.Contact

interface ContactApi {
    fun fetchContacts(): Array<Contact>
}