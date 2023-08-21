package chanchai134.resume.data.repository

import chanchai134.resume.data.model.Job

class FakeJobRepository : JobRepository {
    override fun getJobsRange() = _allJobs.map { it.rangeDate }
    override fun getJobByIndex(index: Int): Job = _allJobs[index]

    private companion object {
        val _allJobs = listOf(
            Job(2,2,2,2,2,listOf(2,2)),
            Job(1,1,1,1,1,listOf(1))
        )
    }
}
