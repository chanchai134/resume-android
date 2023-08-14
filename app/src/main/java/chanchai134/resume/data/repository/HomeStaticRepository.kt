package chanchai134.resume.data.repository

import chanchai134.resume.R
import chanchai134.resume.data.model.Home
import javax.inject.Inject

class HomeStaticRepository @Inject constructor() : HomeRepository {
    override fun getHome(): Home {
        return Home(
            R.drawable.portrait,
            R.drawable.ic_phone,
            R.drawable.ic_mail,
            R.drawable.ic_github,
            R.drawable.ic_linkedin,
            R.string.greetings,
            R.string.full_name,
            R.string.phone_number,
            R.string.e_mail,
            R.string.subject_mail,
            R.string.github,
            R.string.linkedin,
            R.string.call,
            R.string.send_mail,
            R.string.open_github,
            R.string.open_linkedin
        )
    }
}
