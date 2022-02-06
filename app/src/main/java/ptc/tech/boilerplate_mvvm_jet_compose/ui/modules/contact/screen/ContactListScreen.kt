package ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact.viewmodel.ContactListViewModel
import ptc.tech.boilerplate_mvvm_jet_compose.R

@Composable
fun ContactListScreen(
    viewModel: ContactListViewModel
) {
    if (viewModel.loading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize() ){
            CircularProgressIndicator(modifier = Modifier.size(64.dp))
        }
    } else {
        Surface(Modifier.background(color = Color.Transparent)) {
            LazyColumn(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                var contacts = viewModel.contacts
                items(contacts.size) { i ->
                    Row {
                        Image(
                            painter = rememberImagePainter(
                                data = contacts[i].avatar,
                                builder = {
                                    crossfade(true)
                                    placeholder(R.drawable.ic_avatar_placeholder)
                                    transformations(CircleCropTransformation())
                                },
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(80.dp)
                                .padding(8.dp)
                        )
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text("${contacts[i].fullName()}", color = Color.Black, fontSize = 15.sp)
                            Text(
                                "${contacts[i].fullAddress()}",
                                color = Color.Gray,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }
        }
    }
}
