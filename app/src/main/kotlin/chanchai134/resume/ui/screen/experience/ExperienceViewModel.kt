package chanchai134.resume.ui.screen.experience

import androidx.lifecycle.ViewModel
import chanchai134.resume.data.repository.JobRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ExperienceViewModel @Inject constructor(private val jobRepository: JobRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<ExperienceUiState>

    init {
        val ranges = jobRepository.getJobsRange()
        val (title,_,duration,company,jobDetail,skills) = jobRepository.getJobByIndex(0)

        _uiState = MutableStateFlow(
            ExperienceUiState(0,ranges,title,duration,company,jobDetail,skills)
        )
    }

    val uiState = _uiState.asStateFlow()

    fun setJobByIndex(index: Int) {
        val (title,_,duration,company,jobDetail,skills) = jobRepository.getJobByIndex(index)

        _uiState.value = uiState.value.copy(
            selectedIndex = index,
            title = title,
            duration = duration,
            company = company,
            jobDetail = jobDetail,
            skills = skills
        )
    }
}
