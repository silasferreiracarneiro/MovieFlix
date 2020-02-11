package br.com.silas.carneiro.movieflix.di.module

import br.com.silas.carneiro.movieflix.di.PerActivity
import br.com.silas.carneiro.movieflix.ui.detail.DetailContract
import br.com.silas.carneiro.movieflix.ui.detail.DetailPresenter
import br.com.silas.carneiro.movieflix.ui.home.homeMovie.HomeMovieContract
import br.com.silas.carneiro.movieflix.ui.home.homeMovie.HomeMoviePresenter
import br.com.silas.carneiro.movieflix.ui.home.search.SearchContract
import br.com.silas.carneiro.movieflix.ui.home.search.SearchPresenter
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
    fun provideRegisterPresenter(interactorRegister: RegisterContract.Interactor):
            RegisterContract.Presenter<RegisterContract.View, RegisterContract.Interactor> = RegisterPresenter(interactorRegister)

    @Provides
    @PerActivity
    fun provideLoginPresenter(interactor: LoginContract.Interactor):
            LoginContract.Presenter<LoginContract.View, LoginContract.Interactor> =  LoginPresenter(interactor)

    @Provides
    @PerActivity
    fun provideSplashPresenter(interactor: SplashContract.Interactor):
            SplashContract.Presenter<SplashContract.View, SplashContract.Interactor> =  SplashPresenter(interactor)

    @Provides
    @PerActivity
    fun provideHomeMoviePresenter(interactor: HomeMovieContract.Interactor):
            HomeMovieContract.Presenter<HomeMovieContract.View, HomeMovieContract.Interactor> = HomeMoviePresenter(interactor)

    @Provides
    @PerActivity
    fun provideSearchPresenter(interactor: SearchContract.Interactor):
            SearchContract.Presenter<SearchContract.View, SearchContract.Interactor> = SearchPresenter(interactor)

    @Provides
    @PerActivity
    fun provideDetailPresenter(interactor: DetailContract.Interactor):
            DetailContract.Presenter<DetailContract.View, DetailContract.Interactor> = DetailPresenter(interactor)
}