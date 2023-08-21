package chanchai134.resume.data.repository

import chanchai134.resume.R
import chanchai134.resume.data.model.Job
import javax.inject.Inject

class JobStaticRepository @Inject constructor() : JobRepository {
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
                listOf(
                    R.string.node_js,
                    R.string.typescript,
                    R.string.javascript,
                    R.string.c_sharp,
                    R.string.asp_net,
                    R.string.python,
                    R.string.aws,
                    R.string.graph_ql,
                    R.string.rxjs,
                    R.string.git,
                    R.string.oop,
                    R.string.ddd,
                    R.string.elasticsearch,
                    R.string.logstash,
                    R.string.mongodb,
                    R.string.sql,
                    R.string.kafka,
                    R.string.nifi,
                    R.string.docker
                )
            ),
            Job(
                R.string.job_1_title,
                R.string.job_1_range,
                R.string.job_1_duration,
                R.string.job_1_company,
                R.string.job_1_detail,
                listOf(R.string.python, R.string.keras, R.string.oop)
            )
        )
    }
}
