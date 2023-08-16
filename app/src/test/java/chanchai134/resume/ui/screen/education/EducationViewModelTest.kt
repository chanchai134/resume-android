package chanchai134.resume.ui.screen.education

import chanchai134.resume.data.repository.FakeEducationRepository
import org.junit.Assert.assertEquals
import org.junit.Test

class EducationViewModelTest {
    private val fakeEducationRepository = FakeEducationRepository()
    private val educationViewModel = EducationViewModel(fakeEducationRepository)

    @Test
    fun homeViewModel_initial_correctUiState() {
        val expectedUiState = EducationUiState(
            listOf(
                EducationUiState.Education(1, 1),
                EducationUiState.Education(2, 22)
            )
        )

        assertEquals(expectedUiState,educationViewModel.uiState)
    }
}
