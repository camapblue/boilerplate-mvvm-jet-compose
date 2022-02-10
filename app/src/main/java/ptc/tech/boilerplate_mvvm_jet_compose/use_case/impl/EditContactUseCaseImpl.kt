package ptc.tech.boilerplate_mvvm_jet_compose.use_case.impl

import kotlinx.coroutines.delay
import ptc.tech.boilerplate_mvvm_jet_compose.app_state.ContactManager
import ptc.tech.boilerplate_mvvm_jet_compose.global.AppAnalytics
import ptc.tech.boilerplate_mvvm_jet_compose.models.Event
import ptc.tech.boilerplate_mvvm_jet_compose.use_case.EditContactUseCase
import ptc.tech.repository.model.Contact
import ptc.tech.repository.repository.ContactRepository

class EditContactUseCaseImpl(
    private val contactManager: ContactManager,
    private val contactRepository: ContactRepository,
    private val analytics: AppAnalytics = AppAnalytics.instance
): EditContactUseCase {
    override suspend fun editContact(contact: Contact): Contact {
        val updatedContact = contactRepository.editContact(contact = contact)
        delay(2000L)

        contactManager.updateContact(updatedContact)
        analytics.trackEvent(Event("CONTACT_EDIT_USE_CASE",1))
        return updatedContact
    }
}