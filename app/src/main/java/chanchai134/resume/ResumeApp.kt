package chanchai134.resume

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import chanchai134.resume.extension.getCurrentLanguage
import chanchai134.resume.extension.getCurrentMode
import chanchai134.resume.extension.setLanguage
import chanchai134.resume.extension.setMode
import chanchai134.resume.ui.navigation.BottomNavigation
import chanchai134.resume.ui.navigation.Destination
import chanchai134.resume.ui.navigation.ResumeNavigationGraph
import chanchai134.resume.ui.setting.TopAppSetting

@Composable
fun ResumeApp(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val currentDestination = rememberSaveable { arrayOf(Destination.Home) }
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()

    backStackEntry?.let {
        it.destination.route?.let {
            currentDestination[0] = Destination.getDestinationByRoute(it)!!
        }
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppSetting(
                currentDestination.first().label,
                context.getCurrentLanguage(),
                context::setLanguage,
                context.getCurrentMode(),
                context::setMode,
                Modifier.fillMaxWidth()
            )
        },
        bottomBar = {
            BottomNavigation(
                currentDestination.first(),
                Destination.allDestinations,
                {
                    navController.navigate(it.route) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(Destination.Home.route) {
                            saveState = true
                        }
                    }
                },
                Modifier.fillMaxWidth()
            )
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Destination.Home.route,
            modifier = modifier
                .fillMaxSize()
                .padding(it),
            builder = NavGraphBuilder::ResumeNavigationGraph
        )
    }
}
