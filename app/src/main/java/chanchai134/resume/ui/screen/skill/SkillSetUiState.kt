package chanchai134.resume.ui.screen.skill

data class SkillSetUiState(val allSkill: List<Skill>) {
    data class Skill(
        val title: Int,
        val icon: Int,
        val skills: List<Int>
    )
}
