package ptc.tech.boilerplate_mvvm_jet_compose.use_case

import ptc.tech.boilerplate_mvvm_jet_compose.use_case.impl.GetContactsUseCaseImpl
import ptc.tech.repository.repository.Repository

class UseCase {
    companion object {
        fun getContactsUseCase() : GetContactsUseCase {
            return GetContactsUseCaseImpl(
                contactRepository = Repository.instance.contactRepository()
            )
        }
    }
}