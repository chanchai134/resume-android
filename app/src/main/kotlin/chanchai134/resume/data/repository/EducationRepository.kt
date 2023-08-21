package chanchai134.resume.data.repository

import chanchai134.resume.data.model.Education

interface EducationRepository {
    fun getAllEducation(): List<Education>
}
