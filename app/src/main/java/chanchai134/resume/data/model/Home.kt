package chanchai134.resume.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Home(
    @DrawableRes val portrait: Int,
    @DrawableRes val iconPhone: Int,
    @DrawableRes val iconMail: Int,
    @DrawableRes val iconGithub: Int,
    @DrawableRes val iconLinkedin: Int,
    @StringRes val greetings: Int,
    @StringRes val fullName: Int,
    @StringRes val phoneNumber: Int,
    @StringRes val email: Int,
    @StringRes val subjectMail: Int,
    @StringRes val github: Int,
    @StringRes val linkedin: Int,
    @StringRes val call: Int,
    @StringRes val sendMail: Int,
    @StringRes val openGithub: Int,
    @StringRes val openLinkedin: Int,
)
