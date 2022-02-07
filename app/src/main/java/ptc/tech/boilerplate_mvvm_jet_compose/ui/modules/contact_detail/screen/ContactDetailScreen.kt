package ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact_detail.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact_detail.viewmodel.ContactDetailViewModel
import ptc.tech.repository.model.Contact

@Composable
fun ContactDetailScreen(
    viewModel: ContactDetailViewModel
) {
    val contact = viewModel.getContact()
    if (contact is Contact) {
        Column() {
            Text(text = contact.fullName())
        }
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize() ){
            Text("Not found contact with id = ${viewModel.contactId()}")
        }
    }
}
