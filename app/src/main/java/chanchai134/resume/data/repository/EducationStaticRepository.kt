package chanchai134.resume.data.repository

import chanchai134.resume.R
import chanchai134.resume.data.model.Education
import javax.inject.Inject

class EducationStaticRepository @Inject constructor() : EducationRepository {
    override fun getAllEducation() = listOf(
        Education(R.string.education_2_description, R.string.education_2_range),
        Education(R.string.education_1_description, R.string.education_1_range)
    )
}
