package be.renaudraas.kotlinplayground.util.mpv

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

open class BaseMvpPresenter<V : MvpView> : MvpPresenter<V> {

    private var view : V? = null
    private val compositeDisposable = CompositeDisposable()

    protected fun <T> subscribe(observable: Observable<T>, observer: DisposableObserver<T>) {
        val disposable = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer)
        this.compositeDisposable.add(disposable)
    }

    override fun attachView(view: V) {
        this.view = view
    }

    fun getView() : V {
        this.view?.let {
            return this.view!!
        }

        throw NullPointerException("MvpView reference is null. Have you called attachView()?")
    }

    private fun dispose() {
        compositeDisposable.clear()
    }

    override fun detachView() {
        this.view = null

        dispose()
    }
}