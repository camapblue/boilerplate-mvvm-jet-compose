package ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact_detail.screen

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import ptc.tech.boilerplate_mvvm_jet_compose.app_state.AppState
import ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.common.BaseActivity
import ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.common.viewModelFactory
import ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact_detail.viewmodel.ContactDetailViewModel
import ptc.tech.boilerplate_mvvm_jet_compose.use_case.UseCase
import ptc.tech.repository.model.Contact

class ContactDetailActivity : BaseActivity<ContactDetailViewModel>() {
    private lateinit var contactId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        contactId = intent.getStringExtra("contactId")!!

        super.onCreate(savedInstanceState)
    }

    override fun viewModelBuilder(): ViewModelProvider.Factory {
        return viewModelFactory {
            ContactDetailViewModel(
                contactId = contactId,
                contactManager = AppState.instance.contactManager(),
                editContactUseCase = UseCase.editContactUseCase()
            )
        }
    }

    override fun screenTitle(): String {
        val contact = viewModel.contact
        if (contact is Contact) {
            return contact.fullName()
        }
        return "Contact Detail"
    }

    @Composable
    override fun buildScreen() {
        ContactDetailScreen(viewModel = viewModel)
    }

    override fun onStart() {
        super.onStart()

        viewModel.loadContact()
    }
}