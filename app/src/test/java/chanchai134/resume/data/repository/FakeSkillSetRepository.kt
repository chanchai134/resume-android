package chanchai134.resume.data.repository

import chanchai134.resume.data.model.SkillSet

class FakeSkillSetRepository : SkillSetRepository {
    override fun getAllSkillSet(): List<SkillSet> = listOf(
        SkillSet(2,2,listOf(2,2)),
        SkillSet(1,1,listOf(1)),
    )
}
