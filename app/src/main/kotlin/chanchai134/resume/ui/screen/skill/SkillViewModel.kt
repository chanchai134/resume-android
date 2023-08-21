package chanchai134.resume.ui.screen.skill

import androidx.lifecycle.ViewModel
import chanchai134.resume.data.repository.SkillSetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SkillViewModel @Inject constructor(skillSetRepository: SkillSetRepository) : ViewModel() {
    val uiState = SkillSetUiState(
        skillSetRepository.getAllSkillSet().map {
            SkillSetUiState.Skill(it.title, it.icon, it.skills)
        }
    )
}
