package chanchai134.resume.data

import chanchai134.resume.data.repository.HomeRepository
import chanchai134.resume.data.repository.HomeStaticRepository
import chanchai134.resume.data.repository.JobRepository
import chanchai134.resume.data.repository.JobStaticRepository
import chanchai134.resume.data.repository.SkillSetRepository
import chanchai134.resume.data.repository.SkillSetStaticRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindHomeRepository(homeStaticRepository: HomeStaticRepository): HomeRepository

    @Singleton
    @Binds
    abstract fun bindJobRepository(jobStaticRepository: JobStaticRepository): JobRepository

    @Singleton
    @Binds
    abstract fun bindSkillSetRepository(skillSetStaticRepository: SkillSetStaticRepository): SkillSetRepository
}
