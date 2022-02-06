package ptc.tech.repository.repository

import ptc.tech.repository.api.ContactApi
import ptc.tech.repository.api.impl.ContactApiImpl
import ptc.tech.repository.repository.impl.ContactRepositoryImpl

class Repository {
    companion object {
        val instance = Repository()
    }

    // repository
    fun contactRepository(): ContactRepository {
        return ContactRepositoryImpl(
            contactApi = contactApi()
        )
    }

    // api
    fun contactApi(): ContactApi {
        return ContactApiImpl()
    }
}