package gp.android.clientapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.google.android.libraries.places.api.Places
import gp.android.clientapp.common.DependencyContainer
import gp.android.clientapp.ui.AppNavGraph
import gp.android.clientapp.ui.theme.MyApplicationTheme
import java.util.*

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!Places.isInitialized())
            Places.initialize(applicationContext, getString(R.string.maps_api_key), Locale.US)


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


