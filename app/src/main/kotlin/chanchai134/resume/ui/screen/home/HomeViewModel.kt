package chanchai134.resume.ui.screen.home

import androidx.lifecycle.ViewModel
import chanchai134.resume.data.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(homeRepository: HomeRepository) : ViewModel() {
    val uiState = homeRepository.getHome().let {
        HomeUiState(
            it.portrait,
            it.iconPhone,
            it.iconMail,
            it.iconGithub,
            it.iconLinkedin,
            it.greetings,
            it.fullName,
            it.phoneNumber,
            it.email,
            it.subjectMail,
            it.github,
            it.linkedin,
            it.call,
            it.sendMail,
            it.openGithub,
            it.openLinkedin
        )
    }
}
