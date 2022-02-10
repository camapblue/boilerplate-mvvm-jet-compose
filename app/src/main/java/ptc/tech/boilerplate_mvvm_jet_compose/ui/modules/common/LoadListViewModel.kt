package ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.common

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ptc.tech.boilerplate_mvvm_jet_compose.use_case.LoadListUseCase
import ptc.tech.repository.model.Entity

open class LoadListViewModel<Item: Entity>(
    private val loadListUseCase: LoadListUseCase<Item>
): BaseViewModel() {
    var loading by mutableStateOf(false)
    var items by mutableStateOf<Array<Item>?>(null)
    var isRefreshing by mutableStateOf(false)
    var isFirstLaunch = false

    fun start() {
        if (isFirstLaunch && !isRefreshing) {
            return
        }
        viewModelScope.launch(Dispatchers.Main) {
            loading = true
            try {
                items = withContext(Dispatchers.IO) { loadListUseCase.loadItems() }
                loading = false
                isFirstLaunch = true
                if (isRefreshing) {
                    isRefreshing = false
                }
            } catch (exception: Exception) {
                println("Load List Error = $exception")
            }
        }
    }

    fun updateItems(updatedItems: Array<Item>) {
        if (items != null && items!!.size == updatedItems.size) {
            items = null
        }
        items = updatedItems
    }

    fun refresh() {
        isRefreshing = true
        start()
    }
}