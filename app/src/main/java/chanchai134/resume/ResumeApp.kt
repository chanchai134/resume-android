package chanchai134.resume

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import chanchai134.resume.extension.getCurrentLanguage
import chanchai134.resume.extension.setLanguage
import chanchai134.resume.ui.navigation.BottomNavigation
import chanchai134.resume.ui.navigation.Destination
import chanchai134.resume.ui.navigation.ResumeNavigationGraph
import chanchai134.resume.ui.setting.Mode
import chanchai134.resume.ui.setting.TopAppSetting

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResumeApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState() // null and value
    val currentRoute = backStackEntry?.destination?.route
    val currentDestination = Destination.getDestinationByRoute(currentRoute) ?: Destination.Home

    val context = LocalContext.current

    Scaffold(
        modifier = modifier,
        topBar = { TopAppSetting(currentDestination.label, context.getCurrentLanguage(), context::setLanguage, Mode.Light, {}) },
        bottomBar = { BottomNavigation(currentDestination, Destination.allDestinations, { navController.navigate(it.route) }) }
    ) {
        NavHost(
            navController = navController,
            startDestination = Destination.Home.route,
            modifier = modifier.padding(it),
            builder = NavGraphBuilder::ResumeNavigationGraph
        )
    }
}