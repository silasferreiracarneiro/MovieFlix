package br.com.silas.carneiro.movieflix

import android.app.Application
import android.content.Context
import br.com.silas.carneiro.movieflix.di.component.ApplicationComponent
import br.com.silas.carneiro.movieflix.di.component.DaggerApplicationComponent
import br.com.silas.carneiro.movieflix.di.module.ApplicationModule

class App: Application() {

    private lateinit var component: ApplicationComponent
    private lateinit var context: Context

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()

        component.inject(this)

        context = this
    }

    fun getComponent(): ApplicationComponent {
        return component
    }

    fun getContext(): Context {
        return context
    }
}