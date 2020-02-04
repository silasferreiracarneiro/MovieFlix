package br.com.silas.carneiro.movieflix.di.module

import br.com.silas.carneiro.movieflix.di.PerActivity
import br.com.silas.carneiro.movieflix.ui.home.homeMovie.HomeMovieContract
import br.com.silas.carneiro.movieflix.ui.home.homeMovie.HomeMoviePresenter
import br.com.silas.carneiro.movieflix.ui.login.LoginContract
import br.com.silas.carneiro.movieflix.ui.login.LoginPresenter
import br.com.silas.carneiro.movieflix.ui.register.RegisterContract
import br.com.silas.carneiro.movieflix.ui.register.RegisterPresenter
import br.com.silas.carneiro.movieflix.ui.splash.SplashContract
import br.com.silas.carneiro.movieflix.ui.splash.SplashPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    @PerActivity
    fun provideRegister(interactorRegister: RegisterContract.Interactor):
            RegisterContract.Presenter<RegisterContract.View, RegisterContract.Interactor> = RegisterPresenter(interactorRegister)

    @Provides
    @PerActivity
    fun provideLogin(interactor: LoginContract.Interactor):
            LoginContract.Presenter<LoginContract.View, LoginContract.Interactor> =  LoginPresenter(interactor)

    @Provides
    @PerActivity
    fun provideSplash(interactor: SplashContract.Interactor):
            SplashContract.Presenter<SplashContract.View, SplashContract.Interactor> =  SplashPresenter(interactor)

    @Provides
    @PerActivity
    fun provideHomeMovie(interactor: HomeMovieContract.Interactor):
            HomeMovieContract.Presenter<HomeMovieContract.View, HomeMovieContract.Interactor> = HomeMoviePresenter(interactor)

}