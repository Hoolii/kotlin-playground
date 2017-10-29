package be.renaudraas.kotlinplayground.business.usecase

import io.reactivex.Observable

interface UseCase<T> {
    fun execute() : Observable<T>
}