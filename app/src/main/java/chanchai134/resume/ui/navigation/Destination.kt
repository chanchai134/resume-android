package chanchai134.resume.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import chanchai134.resume.R

enum class Destination(
    val route: String,
    @StringRes val label: Int,
    @DrawableRes val icon: Int
) {
    Home("home", R.string.home_title, R.drawable.ic_home),
    Education("education", R.string.education_title, R.drawable.ic_education),
    Experience("experience", R.string.experience_title, R.drawable.ic_exp),
    Skill("skill", R.string.skill_title, R.drawable.ic_skill);

    companion object {
        val allDestinations = values()
        fun getDestinationByRoute(route: String?): Destination? {
            return allDestinations.find { it.route == route }
        }
    }
}
