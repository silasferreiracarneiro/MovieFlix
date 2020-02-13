package br.com.silas.carneiro.movieflix.di.component

import br.com.silas.carneiro.movieflix.di.PerActivity
import br.com.silas.carneiro.movieflix.di.module.DataModule
import br.com.silas.carneiro.movieflix.di.module.InteractorModule
import br.com.silas.carneiro.movieflix.di.module.PresenterModule
import br.com.silas.carneiro.movieflix.ui.detail.DetailActivity
import br.com.silas.carneiro.movieflix.ui.home.homeMovie.HomeMovieFragment
import br.com.silas.carneiro.movieflix.ui.home.more.MoreFragment
import br.com.silas.carneiro.movieflix.ui.home.search.SearchFragment
import br.com.silas.carneiro.movieflix.ui.login.LoginActivity
import br.com.silas.carneiro.movieflix.ui.register.RegisterActivity
import br.com.silas.carneiro.movieflix.ui.splash.SplashActivity
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

    fun inject(activity: LoginActivity)
    fun inject(activity: SplashActivity)
    fun inject(activity: RegisterActivity)
    fun inject(activity: DetailActivity)

    fun inject(fragment: HomeMovieFragment)
    fun inject(fragment: SearchFragment)
    fun inject(fragment: MoreFragment)
}