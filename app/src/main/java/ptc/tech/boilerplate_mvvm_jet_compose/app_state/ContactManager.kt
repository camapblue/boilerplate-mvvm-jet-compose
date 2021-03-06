package ptc.tech.boilerplate_mvvm_jet_compose.app_state

import kotlinx.coroutines.flow.Flow
import ptc.tech.repository.model.Contact

interface ContactManager {
    fun updateContactList(contacts: Array<Contact>)

    fun getContactById(id: String): Contact?

    fun updateContact(contact: Contact)

    fun contactListUpdated(): Flow<Array<Contact>>
}