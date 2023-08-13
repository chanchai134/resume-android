package chanchai134.resume.data.model

import androidx.annotation.StringRes

data class Job(
    @StringRes val title: Int,
    @StringRes val rangeDate: Int,
    @StringRes val duration: Int,
    @StringRes val company: Int,
    @StringRes val jobDetail: Int,
    val skills: List<Int>
)
