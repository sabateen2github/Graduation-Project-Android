package gp.android.clientapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import gp.android.clientapp.common.DependencyContainer
import gp.android.clientapp.ui.AppNavGraph
import gp.android.clientapp.ui.theme.MyApplicationTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val navHostController = rememberNavController()
                navHostController.enableOnBackPressed(true)
                AppNavGraph(
                    navController = navHostController,
                    DependencyContainer.createInstance(LocalContext.current)
                )
            }
        }
    }
}


