package chanchai134.resume.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import chanchai134.resume.ui.HomeScreen

fun NavGraphBuilder.ResumeNavigation() {
    composable(route = Destination.Home.route) { HomeScreen() }
}
