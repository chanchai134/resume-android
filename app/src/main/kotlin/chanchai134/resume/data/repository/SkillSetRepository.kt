package chanchai134.resume.data.repository

import chanchai134.resume.data.model.SkillSet

interface SkillSetRepository {
    fun getAllSkillSet(): List<SkillSet>
}
