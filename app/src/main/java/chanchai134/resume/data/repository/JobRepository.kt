package chanchai134.resume.data.repository

import chanchai134.resume.data.model.Job

interface JobRepository {
    fun getJobsRange(): List<Int>
    fun getJobByIndex(index: Int): Job
}
