package ptc.tech.boilerplate_mvvm_jet_compose.use_case

import ptc.tech.boilerplate_mvvm_jet_compose.use_case.impl.LoadContactListUseCaseImpl
import ptc.tech.repository.model.Contact
import ptc.tech.repository.repository.Repository

class UseCase {
    companion object {
        fun loadContactListUseCase() : LoadListUseCase<Contact> {
            return LoadContactListUseCaseImpl(
                contactRepository = Repository.instance.contactRepository()
            )
        }
    }
}