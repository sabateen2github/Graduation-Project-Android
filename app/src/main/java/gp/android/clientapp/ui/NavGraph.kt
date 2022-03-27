package gp.android.clientapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import gp.android.clientapp.common.DependencyContainer
import gp.android.clientapp.ui.home.HomeScreen
import gp.android.clientapp.ui.myqueues.MyQueuesScreen
import gp.android.clientapp.ui.myqueues.MyQueuesViewModel
import gp.android.clientapp.ui.status.QueueStatusScreen
import gp.android.clientapp.ui.status.QueueStatusViewModel


@Composable
fun AppNavGraph(navController: NavHostController, dependencyContainer: DependencyContainer) {

    val navigationActions = NavigationActions(navController)

    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = NavigationDestinations.HOME
    ) {

        composable(NavigationDestinations.HOME) {
            HomeScreen(navigationActions)
        }
        composable(NavigationDestinations.MyQueues) {
            val myQueuesViewModel: MyQueuesViewModel =
                viewModel(
                    factory = MyQueuesViewModel.provideFactory(
                        "alaa2sabateen",
                        dependencyContainer.repository
                    )
                )
            MyQueuesScreen(navigationActions, myQueuesViewModel)
        }

        composable(
            "${NavigationDestinations.QueueStatus}/{turnId}",
            arguments = listOf(navArgument("turnId") { type = NavType.IntType })
        ) { backStackEntry ->
            val queueStatusViewModel: QueueStatusViewModel =
                viewModel(
                    factory = QueueStatusViewModel.provideFactory(
                        backStackEntry.arguments?.getInt("turnId", -1)!!,
                        dependencyContainer.repository
                    )
                )
            QueueStatusScreen(
                navigationActions = navigationActions,
                viewModel = queueStatusViewModel
            )
        }
    }

}