package chanchai134.resume.ui.screen.home

import chanchai134.resume.data.repository.FakeHomeRepository
import org.junit.Assert.assertEquals
import org.junit.Test

class HomeViewModelTest {
    private val fakeHomeRepository = FakeHomeRepository()
    private val homeViewModel = HomeViewModel(fakeHomeRepository)

    @Test
    fun homeViewModel_initial_correctUiState() {
        val expectedUiState = HomeUiState(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)

        assertEquals(expectedUiState, homeViewModel.uiState)
    }
}
