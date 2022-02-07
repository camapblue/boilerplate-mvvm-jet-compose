package ptc.tech.repository.repository

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import ptc.tech.repository.api.ContactApi
import ptc.tech.repository.model.Contact
import ptc.tech.repository.repository.impl.ContactRepositoryImpl

class ContactRepositoryTest {
    lateinit var contactRepository: ContactRepository

    @Mock
    lateinit var contactApi: ContactApi

    @Before
    fun setUp() {
        this.contactApi = Mockito.mock(ContactApi::class.java)
        this.contactRepository = ContactRepositoryImpl(contactApi = this.contactApi)
    }

    @Test
    fun fetchContacts() {
        // When
        val listContact = arrayOf(
            Contact.fakeContact()
        )
        Mockito.`when`(this.contactApi.fetchContacts()).thenReturn(listContact)

        // Given
        val contacts = this.contactRepository.fetchContacts();

        // Verify
        assertNotNull(contacts)
        assertEquals(contacts.size, 1)
    }
}