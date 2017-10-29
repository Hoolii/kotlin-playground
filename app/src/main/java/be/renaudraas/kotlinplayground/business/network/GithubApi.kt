package be.renaudraas.kotlinplayground.business.network

import be.renaudraas.kotlinplayground.business.network.response.RepositoryResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {

    @GET("users/{user}/repos")
    fun getRepositories(@Path("user") user: String) : Observable<List<RepositoryResponse>>
}