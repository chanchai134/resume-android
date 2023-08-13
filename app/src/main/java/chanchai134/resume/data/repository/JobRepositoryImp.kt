package chanchai134.resume.data.repository

import chanchai134.resume.data.model.Job

class JobRepositoryImp : JobRepository {
    override fun getJobsRange() = _allJobs.map { it.rangeDate }
    override fun getJobByIndex(index: Int): Job = _allJobs[index]

    private companion object {
        val _allJobs = listOf<Job>()
    }
}
