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
): ViewModel() {
    var loading by mutableStateOf(false)

    var items by mutableStateOf<Array<Item>?>(null)

    fun start() {
        println("DO START")
        viewModelScope.launch(Dispatchers.Main) {
            println("OK NOW")
            loading = true
            try {
                println("START LOAD ITEMS")
                items = withContext(Dispatchers.IO) { loadListUseCase.loadItems() }
                println("ITEMS NOW = $items")
                loading = false
            } catch (exception: Exception) {
                println("Error = $exception")
            }
        }
    }
}