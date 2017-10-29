package be.renaudraas.kotlinplayground.ui.github

import be.renaudraas.kotlinplayground.business.model.Repository
import be.renaudraas.kotlinplayground.business.usecase.GetRepositoriesUseCase
import be.renaudraas.kotlinplayground.util.mpv.BaseMvpPresenter
import io.reactivex.observers.DisposableObserver

class GithubPresenter : BaseMvpPresenter<GithubMvpView>() {

    fun fetchRepositories(user: String) {
        getView().onLoading(true)
        subscribe(GetRepositoriesUseCase(user).execute(), object : DisposableObserver<List<Repository>>() {
            override fun onNext(repositories: List<Repository>) {
                getView().onLoading(false)
                getView().onRepositoriesFetched(repositories)
            }

            override fun onComplete() {
            }

            override fun onError(e: Throwable) {
                getView().onLoading(false)
                getView().onError(e)
            }
        })
    }
}