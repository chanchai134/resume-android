package chanchai134.resume.data.repository

import chanchai134.resume.R
import chanchai134.resume.data.model.Job

class JobRepositoryImp : JobRepository {
    override fun getJobsRange() = _allJobs.map { it.rangeDate }
    override fun getJobByIndex(index: Int): Job = _allJobs[index]

    private companion object {
        val _allJobs = listOf(
            Job(
                R.string.job_2_title,
                R.string.job_2_range,
                R.string.job_2_duration,
                R.string.job_2_company,
                R.string.job_2_detail,
                listOf(R.string.github)
            ),
            Job(
                R.string.job_1_title,
                R.string.job_1_range,
                R.string.job_1_duration,
                R.string.job_1_company,
                R.string.job_1_detail,
                listOf(R.string.github)
            )
        )
    }
}
