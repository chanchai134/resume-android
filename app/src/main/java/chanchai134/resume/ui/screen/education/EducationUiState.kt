package chanchai134.resume.ui.screen.education

data class EducationUiState(val allEducation: List<Education>) {
    data class Education(
        val description: Int,
        val range: Int
    )
}
