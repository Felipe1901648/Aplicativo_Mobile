package br.com.faculdade.rubik

import android.app.Application
import java.lang.IllegalStateException

class RubikApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        appInstance = this
    }
    companion object {
        private var appInstance: RubikApplication? = null

        fun get_instance(): RubikApplication {
            if(appInstance == null) {
                throw IllegalStateException("configure a aplicação no manifest")
            }
            return appInstance!!
        }
    }
}