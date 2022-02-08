package ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.common

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {
    var isGlobalLoading by mutableStateOf(false)

    fun showGlobalLoading() {
        isGlobalLoading = true
    }

    fun hideGlobalLoading() {
        isGlobalLoading = false
    }
}