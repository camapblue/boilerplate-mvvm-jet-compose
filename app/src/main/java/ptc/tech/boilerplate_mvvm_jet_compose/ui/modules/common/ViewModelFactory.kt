package ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

public inline fun <VM : ViewModel> viewModelFactory(crossinline f: () -> VM) =
    object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(aClass: Class<T>):T = f() as T
    }