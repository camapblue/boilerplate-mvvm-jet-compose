package ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import ptc.tech.boilerplate_mvvm_jet_compose.app_state.AppState
import ptc.tech.boilerplate_mvvm_jet_compose.models.Event
import ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.common.BaseActivity
import ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.common.viewModelFactory
import ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact.viewmodel.ContactListViewModel
import ptc.tech.boilerplate_mvvm_jet_compose.use_case.UseCase

class ContactListActivity : BaseActivity<ContactListViewModel>() {
    override fun viewModelBuilder(): ViewModelProvider.Factory {
        return viewModelFactory { ContactListViewModel(
                UseCase.loadContactListUseCase(),
                AppState.instance.contactManager()
            )
        }
    }

    override fun screenTitle(): String {
        return "Contact List"
    }

    @Composable
    override fun buildScreen() {
        ContactListScreen(viewModel = viewModel)
    }

    override fun onStart() {
        super.onStart()

        viewModel.start()
    }
}