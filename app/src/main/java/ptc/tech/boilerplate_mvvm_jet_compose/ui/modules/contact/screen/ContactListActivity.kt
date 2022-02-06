package ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact.screen

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.common.viewModelFactory
import ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact.viewmodel.ContactListViewModel
import ptc.tech.boilerplate_mvvm_jet_compose.ui.theme.Boilerplate_mvvm_jet_composeTheme
import ptc.tech.boilerplate_mvvm_jet_compose.use_case.UseCase

class ContactListActivity : ComponentActivity() {
    private lateinit var viewModel: ContactListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            viewModelFactory { ContactListViewModel(UseCase.loadContactListUseCase()) }
        ).get(ContactListViewModel::class.java)

        setContent {
            val activity = (LocalContext.current as? Activity)

            Boilerplate_mvvm_jet_composeTheme {
                Scaffold(topBar = {
                    TopAppBar(
                        title = { Text("Contact List") },
                        navigationIcon = {
                            IconButton(onClick = {
                                activity?.finish()
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = "Back",
                                )
                            }
                        }
                    )
                }) {
                    ContactListScreen(viewModel = viewModel)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.start()
    }
}