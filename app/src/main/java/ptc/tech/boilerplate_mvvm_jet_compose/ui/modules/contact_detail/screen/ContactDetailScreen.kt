package ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact_detail.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    val contact = viewModel.contact
    if (contact is Contact) {
        val firstName = remember {
            mutableStateOf(contact!!.firstName)
        }
        val lastName = remember {
            mutableStateOf(contact!!.lastName)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Avatar(imageUrl = contact.avatar, sizeInDp = 92F)
            Spacer(modifier = Modifier.height(24.dp))
            Row(modifier = Modifier
                .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    modifier = Modifier.width(120.dp),
                    value = firstName.value,
                    onValueChange = {
                        firstName.value = it
                    },
                    label = { Text("First name") }
                )
                Spacer(modifier = Modifier.width(32.dp))
                OutlinedTextField(
                    modifier = Modifier.width(120.dp),
                    value = lastName.value,
                    onValueChange = {
                        lastName.value = it
                    },
                    label = { Text("Last name") }
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            PrimaryButton(
                onClickListener = {
                    viewModel.editContact(firstName = firstName.value, lastName = lastName.value)
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
