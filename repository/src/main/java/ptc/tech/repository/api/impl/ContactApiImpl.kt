package ptc.tech.repository.api.impl

import ptc.tech.repository.api.BaseApi
import ptc.tech.repository.api.ContactApi
import ptc.tech.repository.model.Contact

class ContactApiImpl: BaseApi(), ContactApi {
    override fun fetchContacts(): Array<Contact> {
        val url = "https://randomuser.me/api/?results=20"

        val jsonObject = get(url)
        val jsonArray = jsonObject.getJSONArray("results")
        val contactList: MutableList<Contact> = ArrayList()
        for (i in 0 until jsonArray.length()) {
            val contact = Contact(jsonArray.getJSONObject(i))
            contactList.add(contact)
        }
        return contactList.toTypedArray()
    }
}