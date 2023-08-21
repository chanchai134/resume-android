package chanchai134.resume.data

import chanchai134.resume.data.repository.EducationRepository
import chanchai134.resume.data.repository.EducationStaticRepository
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
    @Binds
    abstract fun bindHomeRepository(homeStaticRepository: HomeStaticRepository): HomeRepository

    @Binds
    abstract fun bindJobRepository(jobStaticRepository: JobStaticRepository): JobRepository

    @Binds
    abstract fun bindEducationRepository(educationStaticRepository: EducationStaticRepository): EducationRepository

    @Binds
    abstract fun bindSkillSetRepository(skillSetStaticRepository: SkillSetStaticRepository): SkillSetRepository
}
