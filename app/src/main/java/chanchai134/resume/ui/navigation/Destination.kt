package chanchai134.resume.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import chanchai134.resume.R

enum class Destination(
    val route: String,
    @StringRes val label: Int,
    val icon: ImageVector
) {
    Home("home", R.string.app_name, Icons.Filled.Home)
}
