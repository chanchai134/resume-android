package chanchai134.resume.ui.screen.experience

import androidx.lifecycle.ViewModel
import chanchai134.resume.data.repository.JobRepository
import chanchai134.resume.data.repository.JobRepositoryImp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ExperienceViewModel : ViewModel() {
    val jobRepository: JobRepository = JobRepositoryImp()

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
