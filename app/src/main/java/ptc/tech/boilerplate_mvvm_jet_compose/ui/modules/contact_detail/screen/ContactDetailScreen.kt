package ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact_detail.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact_detail.viewmodel.ContactDetailViewModel
import ptc.tech.jet_components.Avatar
import ptc.tech.jet_components.PrimaryButton
import ptc.tech.repository.model.Contact

@Composable
fun ContactDetailScreen(
    viewModel: ContactDetailViewModel
) {
    val contact = viewModel.getContact()
    if (contact is Contact) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = contact.fullName())
            Spacer(modifier = Modifier.height(32.dp))
            Avatar(imageUrl = contact.avatar, sizeInDp = 92F)
            Spacer(modifier = Modifier.height(32.dp))
            PrimaryButton(
                onClickListener = {

                }
            )
            Spacer(modifier = Modifier.height(32.dp))
        }
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize() ){
            Text("Not found contact with id = ${viewModel.contactId()}")
        }
    }
}
