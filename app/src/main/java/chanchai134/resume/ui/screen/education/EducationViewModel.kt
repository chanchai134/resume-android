package chanchai134.resume.ui.screen.education

import androidx.lifecycle.ViewModel
import chanchai134.resume.data.repository.EducationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EducationViewModel @Inject constructor(educationRepository: EducationRepository) : ViewModel() {
    val uiState = EducationUiState(
        educationRepository.getAllEducation().map {
            EducationUiState.Education(it.description, it.range)
        }
    )
}
