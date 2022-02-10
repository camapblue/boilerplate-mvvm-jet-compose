package ptc.tech.repository.api

import ptc.tech.repository.model.Contact

interface ContactApi {
    suspend fun fetchContacts(): Array<Contact>
}