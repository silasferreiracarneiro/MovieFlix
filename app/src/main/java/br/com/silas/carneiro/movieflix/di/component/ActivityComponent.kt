package br.com.silas.carneiro.movieflix.di.component

import android.app.Application
import android.content.Context
import br.com.silas.carneiro.movieflix.App
import br.com.silas.carneiro.movieflix.data.config.FirebaseConfigContract
import br.com.silas.carneiro.movieflix.data.prefs.PreferencesHelper
import br.com.silas.carneiro.movieflix.di.ApplicationContext
import br.com.silas.carneiro.movieflix.di.PerActivity
import br.com.silas.carneiro.movieflix.di.module.DataModule
import br.com.silas.carneiro.movieflix.di.module.InteractorModule
import br.com.silas.carneiro.movieflix.di.module.PresenterModule
import dagger.Component

@PerActivity
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [
        PresenterModule::class,
        InteractorModule::class,
        DataModule::class
    ])
interface ActivityComponent {

    fun inject(app: App)

    @ApplicationContext
    fun context(): Context

    fun preferencesHelper(): PreferencesHelper

    fun application(): Application

    fun firebaseConfig(): FirebaseConfigContract

}