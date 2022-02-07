package ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.common

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ptc.tech.boilerplate_mvvm_jet_compose.ui.theme.Boilerplate_mvvm_jet_composeTheme

open class BaseActivity<VM: ViewModel>(
    private val screenTitle: String,
    private val viewModelBuilder: ViewModelProvider.Factory,
    private val screenBuilder: @Composable() (viewModel: VM) -> Unit
) : ComponentActivity() {
    private lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            viewModelBuilder
        ).get(ViewModel::class.java) as VM

        setContent {
            val activity = (LocalContext.current as? Activity)

            Boilerplate_mvvm_jet_composeTheme {
                Scaffold(topBar = {
                    TopAppBar(
                        title = { Text(screenTitle) },
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
                    screenBuilder(viewModel = viewModel)
                }
            }
        }
    }
}