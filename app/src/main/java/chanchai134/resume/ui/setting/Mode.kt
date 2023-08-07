package chanchai134.resume.ui.setting

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.vector.ImageVector

enum class Mode(val icon: ImageVector) {
    Light(Icons.Filled.Share),
    Dark(Icons.Filled.Search)
}