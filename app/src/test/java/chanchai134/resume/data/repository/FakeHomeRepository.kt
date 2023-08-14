package chanchai134.resume.data.repository

import chanchai134.resume.data.model.Home

class FakeHomeRepository: HomeRepository {
    override fun getHome(): Home {
        return Home(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)
    }
}
