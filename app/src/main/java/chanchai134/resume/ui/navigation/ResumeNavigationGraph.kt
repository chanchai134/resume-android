package chanchai134.resume.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import chanchai134.resume.ui.HomeScreen

fun NavGraphBuilder.ResumeNavigationGraph() {
    composable(route = Destination.Home.route) { HomeScreen() }
    composable(route = Destination.Exp.route) { HomeScreen() }
}
