package chanchai134.resume.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SkillSet(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val skills: List<Int>
)
