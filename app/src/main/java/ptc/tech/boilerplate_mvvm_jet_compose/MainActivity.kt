package ptc.tech.boilerplate_mvvm_jet_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ptc.tech.boilerplate_mvvm_jet_compose.ui.modules.launching.SplashScreen
import ptc.tech.boilerplate_mvvm_jet_compose.ui.theme.Boilerplate_mvvm_jet_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Boilerplate_mvvm_jet_composeTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()

                Scaffold() {
                    NavHost(navController, startDestination = "splash") {
                        composable(route = "splash") {
                            SplashScreen()
                        }
                    }
                }
            }
        }
    }
}
