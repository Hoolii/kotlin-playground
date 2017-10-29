package be.renaudraas.kotlinplayground.ui.github

import be.renaudraas.kotlinplayground.business.model.Repository
import be.renaudraas.kotlinplayground.util.mpv.MvpView

interface GithubMvpView : MvpView {
    fun onLoading(isLoading: Boolean)
    fun onRepositoriesFetched(repositories: List<Repository>)
    fun onError(throwable: Throwable)
}