package chanchai134.resume

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import chanchai134.resume.ui.navigation.Destination
import chanchai134.resume.ui.navigation.ResumeNavigation

@Composable
fun ResumeApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destination.Home.route,
        modifier = modifier,
        builder = NavGraphBuilder::ResumeNavigation
    )
}
