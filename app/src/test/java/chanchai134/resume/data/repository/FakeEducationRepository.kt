package chanchai134.resume.data.repository

import chanchai134.resume.data.model.Education

class FakeEducationRepository : EducationRepository {
    override fun getAllEducation() = listOf(
        Education(1, 1),
        Education(2, 22)
    )
}
