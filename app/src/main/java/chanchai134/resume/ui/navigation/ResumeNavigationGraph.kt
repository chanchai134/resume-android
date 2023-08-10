package chanchai134.resume.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import chanchai134.resume.ui.HomeScreen
import chanchai134.resume.ui.SkillScreen

fun NavGraphBuilder.ResumeNavigationGraph() {
    composable(route = Destination.Home.route) { HomeScreen() }
    composable(route = Destination.Education.route) { SkillScreen() }
    composable(route = Destination.Experience.route) { SkillScreen() }
    composable(route = Destination.Skill.route) { SkillScreen() }
}
