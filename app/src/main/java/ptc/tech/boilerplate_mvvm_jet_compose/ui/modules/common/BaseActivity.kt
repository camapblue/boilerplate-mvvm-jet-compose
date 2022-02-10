package ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.common

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ptc.tech.boilerplate_mvvm_jet_compose.models.Event
import ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.app_showing.GlobalLoading
import ptc.tech.boilerplate_mvvm_jet_compose.ui.theme.Boilerplate_mvvm_jet_composeTheme

open class BaseActivity<VM: BaseViewModel>: ComponentActivity() {
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            viewModelBuilder()
        ).get(ViewModel::class.java) as VM

        viewModel.errorMessage.observe(this, {
            if (it.isNotBlank()) {
                Toast.makeText(this@BaseActivity, it, Toast.LENGTH_SHORT).show()
            }
        })

        setContent {
            val activity = (LocalContext.current as? Activity)

            Boilerplate_mvvm_jet_composeTheme {
                Scaffold(topBar = {
                    TopAppBar(
                        title = { Text(screenTitle()) },
                        navigationIcon = {
                            IconButton(onClick = {
                                activity?.finish()
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = "Back",
                                )
                            }
                        }
                    )
                }) {
                    if (viewModel.isGlobalLoading) {
                        Box {
                            buildScreen()
                            GlobalLoading()
                        }
                    } else {
                        buildScreen()
                    }
                }
            }
        }
    }

    open fun viewModelBuilder(): ViewModelProvider.Factory {
        return viewModelFactory { BaseViewModel() }
    }

    open fun screenTitle(): String {
        return ""
    }

    @Composable
    open fun buildScreen() {
        Text(text = "Empty screen")
    }

    override fun onStart() {
        super.onStart()

        viewModel.trackEvent(Event(screenTitle(), 1))

        viewModel.bindEvents()
    }
}