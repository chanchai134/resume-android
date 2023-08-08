package chanchai134.resume

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import chanchai134.resume.extension.getCurrentLanguage
import chanchai134.resume.extension.getCurrentMode
import chanchai134.resume.extension.setLanguage
import chanchai134.resume.extension.setMode
import chanchai134.resume.ui.navigation.BottomNavigation
import chanchai134.resume.ui.navigation.Destination
import chanchai134.resume.ui.navigation.ResumeNavigationGraph
import chanchai134.resume.ui.setting.TopAppSetting

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResumeApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    val startDestination = Destination.Home
    var currentDestination by rememberSaveable {
        mutableStateOf(startDestination)
    }

    val context = LocalContext.current

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppSetting(
                currentDestination.label,
                context.getCurrentLanguage(),
                context::setLanguage,
                context.getCurrentMode(),
                context::setMode,
                Modifier.fillMaxWidth()
            )
        },
        bottomBar = {
            BottomNavigation(
                currentDestination,
                Destination.allDestinations,
                {
                    currentDestination = it
                    navController.navigate(it.route)
                },
                Modifier.fillMaxWidth()
            )
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = startDestination.route,
            modifier = modifier
                .fillMaxSize()
                .padding(it),
            builder = NavGraphBuilder::ResumeNavigationGraph
        )
    }
}
