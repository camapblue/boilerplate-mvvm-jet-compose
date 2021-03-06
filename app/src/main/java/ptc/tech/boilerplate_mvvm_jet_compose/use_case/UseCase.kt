package ptc.tech.boilerplate_mvvm_jet_compose.use_case

import ptc.tech.boilerplate_mvvm_jet_compose.app_state.AppState
import ptc.tech.boilerplate_mvvm_jet_compose.use_case.impl.EditContactUseCaseImpl
import ptc.tech.boilerplate_mvvm_jet_compose.use_case.impl.LoadContactListUseCaseImpl
import ptc.tech.repository.model.Contact
import ptc.tech.repository.repository.Repository

class UseCase {
    companion object {
        fun editContactUseCase() : EditContactUseCase {
            return EditContactUseCaseImpl(
                contactManager = AppState.instance.contactManager(),
                contactRepository = Repository.instance.contactRepository()
            )
        }

        // list
        fun loadContactListUseCase() : LoadListUseCase<Contact> {
            return LoadContactListUseCaseImpl(
                contactManager = AppState.instance.contactManager(),
                contactRepository = Repository.instance.contactRepository()
            )
        }
    }
}