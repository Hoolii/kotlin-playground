package be.renaudraas.kotlinplayground.application

import android.app.Application

class PlaygroundApplication : Application() {

    companion object {
        lateinit var instance: PlaygroundApplication
            private set get
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
    }
}