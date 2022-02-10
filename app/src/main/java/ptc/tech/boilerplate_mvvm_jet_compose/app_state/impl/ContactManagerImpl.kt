package ptc.tech.boilerplate_mvvm_jet_compose.app_state.impl

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ptc.tech.boilerplate_mvvm_jet_compose.app_state.ContactManager
import ptc.tech.repository.model.Contact

class ContactManagerImpl: ContactManager {
    private var contacts: Array<Contact>? = null

    override fun updateContactList(contacts: Array<Contact>) {
        this.contacts = contacts
    }

    override fun getContactById(id: String): Contact? {
        if (contacts == null || contacts!!.isEmpty()) {
            return null
        }

        return contacts!!.firstOrNull { it.id == id }
    }

    override fun updateContact(contact: Contact) {
        if (contacts == null || contacts!!.isEmpty()) {
            return
        }
        contacts!!.forEachIndexed { index, video ->
            video.takeIf { it.id == contact.id }?.let {
                println("EDIT CONTACT NOW = $contact")
                contacts!![index] = contact
            }
        }
        GlobalScope.launch {
            println("HEY CONTACTS NOW = $contacts!!")
            updatedContactList.emit(contacts!!)
        }
    }

    private val updatedContactList = MutableSharedFlow<Array<Contact>>()

    override fun contactListUpdated(): Flow<Array<Contact>> {
        return updatedContactList.asSharedFlow()
    }
}