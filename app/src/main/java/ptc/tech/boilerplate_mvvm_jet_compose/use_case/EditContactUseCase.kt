package ptc.tech.boilerplate_mvvm_jet_compose.use_case

import ptc.tech.repository.model.Contact

interface EditContactUseCase {
    suspend fun editContact(contact: Contact): Contact
}