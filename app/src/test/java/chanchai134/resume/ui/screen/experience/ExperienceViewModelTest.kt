package chanchai134.resume.ui.screen.experience

import chanchai134.resume.data.repository.FakeJobRepository
import org.junit.Assert.assertEquals
import org.junit.Test

class ExperienceViewModelTest {
    private val fakeJobRepository = FakeJobRepository()
    private val experienceViewModel = ExperienceViewModel(fakeJobRepository)

    @Test
    fun experienceViewModel_initial_correctUiState() {
        val expectedUiState = ExperienceUiState(0,listOf(2,1),2,2,2,2,listOf(2,2))

        assertEquals(expectedUiState, experienceViewModel.uiState.value)
    }

    @Test
    fun experienceViewModel_setJobByIndex_correctUiState() {
        experienceViewModel.setJobByIndex(1)

        val expectedUiState = ExperienceUiState(1,listOf(2,1),1,1,1,1,listOf(1))

        assertEquals(expectedUiState, experienceViewModel.uiState.value)
    }
}
