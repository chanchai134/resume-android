package chanchai134.resume.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import chanchai134.resume.ui.EducationScreen
import chanchai134.resume.ui.HomeScreen
import chanchai134.resume.ui.SkillScreen
import chanchai134.resume.ui.screen.experience.ExperienceScreen

fun NavGraphBuilder.ResumeNavigationGraph() {
    composable(route = Destination.Home.route) { HomeScreen() }
    composable(route = Destination.Education.route) { EducationScreen() }
    composable(route = Destination.Experience.route) { ExperienceScreen() }
    composable(route = Destination.Skill.route) { SkillScreen() }
}
