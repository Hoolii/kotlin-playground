package be.renaudraas.kotlinplayground.business.usecase

import be.renaudraas.kotlinplayground.business.model.Repository
import be.renaudraas.kotlinplayground.business.network.ApiManager
import be.renaudraas.kotlinplayground.business.network.response.toRepository
import io.reactivex.Observable

class GetRepositoriesUseCase(val user: String) : UseCase<List<Repository>> {

    override fun execute(): Observable<List<Repository>> {
        return ApiManager.githubApi.getRepositories(user).map {
            val repositories = mutableListOf<Repository>()

            it.forEach { repositories.add(it.toRepository()) }

            repositories
        }
    }
}