package ptc.tech.boilerplate_mvvm_jet_compose.app_state.impl

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
                contacts!![index] = contact
            }
        }
    }
}