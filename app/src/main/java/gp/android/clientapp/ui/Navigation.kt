package gp.android.clientapp.ui

import androidx.navigation.NavHostController

object NavigationDestinations {
    const val HOME = "Home"
    const val MyQueues = "MyQueues"
    const val QueueStatus = "MyQueues/QueueStatus"

}

class NavigationActions(navController: NavHostController) {
    val navigateToHome: () -> Unit = {
        navController.navigateSingle(NavigationDestinations.HOME)
    }

    val navigateToMyQueues: () -> Unit = {
        navController.navigateSingle(NavigationDestinations.MyQueues)
    }

    val navigateToQueueStatus: (turnId: Int) -> Unit = { turnId ->
        navController.navigateSingle("${NavigationDestinations.QueueStatus}/$turnId")
    }

    val navigateBack: () -> Unit = {
        navController.popBackStack()
    }
}

fun NavHostController.navigateSingle(route: String) {
    if (!popBackStack(route = route, inclusive = false))
        navigate(route) {
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }

}