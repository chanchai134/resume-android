package chanchai134.resume.ui.navigation

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import chanchai134.resume.EmptyActivity
import chanchai134.resume.ResumeApp
import chanchai134.resume.ui.theme.ResumeandroidTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class NavigationTest {
    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<EmptyActivity>()

    lateinit var navController: TestNavHostController

    @Before
    fun setupResumeApp() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            ResumeandroidTheme {
                ResumeApp(navController = navController)
            }
        }
    }

    @Test
    fun navHost_startDestination_correctRoute() {
        assertEquals(
            Destination.Home.route,
            navController.currentBackStackEntry?.destination?.route
        )
    }

    @Test
    fun navHost_navigateExperience_correctRoute() {
        composeTestRule
            .onNodeWithTag(Destination.Experience.route)
            .performClick()

        assertEquals(
            Destination.Experience.route,
            navController.currentBackStackEntry?.destination?.route
        )
    }

    @Test
    fun navHost_navigateEducation_correctRoute() {
        composeTestRule
            .onNodeWithTag(Destination.Education.route)
            .performClick()

        assertEquals(
            Destination.Education.route,
            navController.currentBackStackEntry?.destination?.route
        )
    }

    @Test
    fun navHost_navigateSkill_correctRoute() {
        composeTestRule
            .onNodeWithTag(Destination.Skill.route)
            .performClick()

        assertEquals(
            Destination.Skill.route,
            navController.currentBackStackEntry?.destination?.route
        )
    }

    @Test
    fun navHost_navigateMultipleScreenAndBackPress_goToHome() {
        composeTestRule
            .onNodeWithTag(Destination.Skill.route)
            .performClick()
        composeTestRule
            .onNodeWithTag(Destination.Education.route)
            .performClick()

        composeTestRule.activityRule.scenario.onActivity { activity ->
            activity.onBackPressedDispatcher.onBackPressed()
        }

        assertEquals(
            Destination.Home.route,
            navController.currentBackStackEntry?.destination?.route
        )
        assertNull(navController.previousBackStackEntry)
    }
}
