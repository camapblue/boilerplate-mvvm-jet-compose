package ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.common

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
import ptc.tech.repository.model.Entity

@Composable
fun <Item: Entity> LoadListView(
    viewModel: LoadListViewModel<Item>,
    modifier: Modifier = Modifier,
    itemBuilder: @Composable() (item: Item) -> Unit
) = if (viewModel.loading || viewModel.items == null) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize() ){
        CircularProgressIndicator(modifier = Modifier.size(64.dp))
    }
} else {
    Surface(Modifier.background(color = Color.Transparent)) {
        var items = viewModel.items
        if (items!!.isEmpty()) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()) {
                Text(text = "No items")
            }
        }
        else {
            LazyColumn(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                items(items.size) { i ->
                    itemBuilder(items[i])
                }
            }
        }
    }
}