package be.renaudraas.kotlinplayground.util.mpv

interface MvpPresenter<V : MvpView> {

    fun attachView(view: V)

    fun detachView()
}