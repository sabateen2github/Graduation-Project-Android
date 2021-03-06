package gp.android.clientapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import gp.android.clientapp.common.DependencyContainer
import gp.android.clientapp.ui.book.BookTurnScreen
import gp.android.clientapp.ui.book.BookingViewModel
import gp.android.clientapp.ui.bookqueue.BookQueueScreen
import gp.android.clientapp.ui.bookqueue.BookQueueViewModel
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

        composable(NavigationDestinations.Booking) {
            val bookingViewModel: BookingViewModel =
                viewModel(
                    factory = BookingViewModel.provideFactory(
                        queuesRepository = dependencyContainer.repository,
                        dependencyContainer.branchRepository
                    )
                )

            BookTurnScreen(navigationActions, bookingViewModel)
        }
        composable(NavigationDestinations.MyQueues) {
            val myQueuesViewModel: MyQueuesViewModel =
                viewModel(
                    factory = MyQueuesViewModel.provideFactory(
                        dependencyContainer.repository,
                        LocalContext.current
                    )
                )
            MyQueuesScreen(navigationActions, myQueuesViewModel)
        }

        composable(
            "${NavigationDestinations.QueueStatus}/{turnId}",
            arguments = listOf(navArgument("turnId") { type = NavType.StringType })
        ) { backStackEntry ->
            val queueStatusViewModel: QueueStatusViewModel =
                viewModel(
                    factory = QueueStatusViewModel.provideFactory(
                        backStackEntry.arguments?.getString("turnId", null)!!,
                        dependencyContainer.repository
                    )
                )
            QueueStatusScreen(
                navigationActions = navigationActions,
                viewModel = queueStatusViewModel
            )
        }

        composable(
            "${NavigationDestinations.BookQueue}/{instituteId}/{branchId}",
            arguments = listOf(
                navArgument("branchId") { type = NavType.StringType },
                navArgument("instituteId") { type = NavType.StringType })
        ) { backStackEntry ->
            val bookQueueViewModel: BookQueueViewModel =
                viewModel(
                    factory = BookQueueViewModel.provideFactory(
                        context = LocalContext.current,
                        branchID = backStackEntry.arguments?.getString("branchId", null)!!,
                        instituteId = backStackEntry.arguments?.getString("instituteId", null)!!,
                        repository = dependencyContainer.repository,
                        fusedLocationProviderClient = dependencyContainer.fusedLocationProviderClient
                    )
                )
            BookQueueScreen(
                viewModel = bookQueueViewModel,
                navigationActions = navigationActions
            )
        }
    }

}