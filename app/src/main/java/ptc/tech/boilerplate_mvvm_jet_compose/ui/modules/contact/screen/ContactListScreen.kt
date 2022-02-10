package ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact.screen

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact.viewmodel.ContactListViewModel
import ptc.tech.boilerplate_mvvm_jet_compose.R
import ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.common.LoadListView
import ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.contact_detail.screen.ContactDetailActivity
import ptc.tech.repository.model.Contact

@Composable
fun ContactListScreen(
    viewModel: ContactListViewModel
) {
    val context = LocalContext.current

    LoadListView<Contact>(viewModel = viewModel) {
        Row(modifier = Modifier
            .clickable {
                val intent = Intent(context, ContactDetailActivity::class.java)
                intent.putExtra("contactId", it.id)
                context.startActivity(intent)
            }
        ) {
            Image(
                painter = rememberImagePainter(
                    data = it.avatar,
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
                Text("${it.fullName()}", color = Color.Black, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                Text(
                    "${it.fullAddress()}",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
        }
    }
}
