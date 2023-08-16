package chanchai134.resume.data.repository

import chanchai134.resume.R
import chanchai134.resume.data.model.SkillSet
import javax.inject.Inject

class SkillSetStaticRepository @Inject constructor() : SkillSetRepository {
    override fun getAllSkillSet() = listOf(
        SkillSet(
            R.string.android,
            R.drawable.ic_android,
            listOf(
                R.string.kotlin,
                R.string.android_studio,
                R.string.view,
                R.string.view_binding,
                R.string.data_binding,
                R.string.jetpack_compose,
                R.string.view_model,
                R.string.coroutine,
                R.string.git,
                R.string.room,
                R.string.data_store,
                R.string.retrofit,
                R.string.graph_ql,
                R.string.mockito,
                R.string.oop,
                R.string.reactive_programing
            )
        ),
        SkillSet(
            R.string.back_end_eveloper,
            R.drawable.ic_backend,
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
                R.string.elasticsearch,
                R.string.logstash,
                R.string.mongodb,
                R.string.sql,
                R.string.kafka,
                R.string.nifi,
                R.string.docker,
                R.string.oop,
                R.string.ddd
            )
        )
    )
}
