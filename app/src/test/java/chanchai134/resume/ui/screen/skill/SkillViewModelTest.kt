package chanchai134.resume.ui.screen.skill

import chanchai134.resume.data.repository.FakeSkillSetRepository
import org.junit.Assert.assertEquals
import org.junit.Test

class SkillViewModelTest {
    private val fakeSkillSetRepository = FakeSkillSetRepository()
    private val skillViewModel = SkillViewModel(fakeSkillSetRepository)

    @Test
    fun skillViewModelTest_initial_correctUiState() {
        val expectedUiState = SkillSetUiState(listOf(
            SkillSetUiState.Skill(2,2,listOf(2,2)),
            SkillSetUiState.Skill(1,1,listOf(1))
        ))

        assertEquals(expectedUiState, skillViewModel.uiState)
    }
}
