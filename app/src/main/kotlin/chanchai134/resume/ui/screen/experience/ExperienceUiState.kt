package chanchai134.resume.ui.screen.experience

data class ExperienceUiState(
    val selectedIndex: Int,
    val rangeTitleTab: List<Int>,
    val title: Int,
    val duration: Int,
    val company: Int,
    val jobDetail: Int,
    val skills: List<Int>
)
