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
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ptc.tech.repository.model.Entity

@Composable
fun <Item: Entity> LoadListView(
    viewModel: LoadListViewModel<Item>,
    modifier: Modifier = Modifier,
    itemSort: Comparator<Item>? = null,
    itemBuilder: @Composable() (item: Item) -> Unit
) = if ((viewModel.loading && !viewModel.isRefreshing) || viewModel.items == null) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize() ){
        CircularProgressIndicator(modifier = Modifier.size(64.dp))
    }
} else {
    println("RELOAD NOW")
    Surface(Modifier.background(color = Color.Transparent)) {
        val items = viewModel.items
        if (itemSort != null) {
            items!!.sortWith(itemSort)
        }

        if (items!!.isEmpty()) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()) {
                Text(text = "No items")
            }
        }
        else {
            SwipeRefresh(
                state = rememberSwipeRefreshState(viewModel.isRefreshing),
                onRefresh = { viewModel.refresh() },
            ) {
                LazyColumn(
                    modifier = modifier.padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top,
                ) {
                    items(items.size, { index -> items[index].key() }) { i ->
                        itemBuilder(items[i])
                    }
                }
            }
        }
    }
}