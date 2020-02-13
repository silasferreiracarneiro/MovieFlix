package br.com.silas.carneiro.movieflix.di.module

import br.com.silas.carneiro.movieflix.data.firebase.contract.ApiServiceFirebaseContract
import br.com.silas.carneiro.movieflix.data.network.contract.ApiContract
import br.com.silas.carneiro.movieflix.data.prefs.PreferencesHelper
import br.com.silas.carneiro.movieflix.di.PerActivity
import br.com.silas.carneiro.movieflix.ui.detail.DetailContract
import br.com.silas.carneiro.movieflix.ui.detail.DetailInteractor
import br.com.silas.carneiro.movieflix.ui.home.homeMovie.HomeMovieContract
import br.com.silas.carneiro.movieflix.ui.home.homeMovie.HomeMovieInteractor
import br.com.silas.carneiro.movieflix.ui.home.more.MoreContract
import br.com.silas.carneiro.movieflix.ui.home.more.MoreInteractor
import br.com.silas.carneiro.movieflix.ui.home.search.SearchContract
import br.com.silas.carneiro.movieflix.ui.home.search.SearchInteractor
import br.com.silas.carneiro.movieflix.ui.login.LoginContract
import br.com.silas.carneiro.movieflix.ui.login.LoginInteractor
import br.com.silas.carneiro.movieflix.ui.register.RegisterContract
import br.com.silas.carneiro.movieflix.ui.register.RegisterInteractor
import br.com.silas.carneiro.movieflix.ui.splash.SplashContract
import br.com.silas.carneiro.movieflix.ui.splash.SplashInteractor
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    @PerActivity
    fun provideRegister(api: ApiServiceFirebaseContract): RegisterContract.Interactor = RegisterInteractor(api)

    @Provides
    @PerActivity
    fun provideLogin(api: ApiServiceFirebaseContract, apiPref: PreferencesHelper): LoginContract.Interactor = LoginInteractor(api, apiPref)

    @Provides
    @PerActivity
    fun provideSplash(api: ApiServiceFirebaseContract, apiPref: PreferencesHelper): SplashContract.Interactor = SplashInteractor(api, apiPref)

    @Provides
    @PerActivity
    fun provideHomeMovie(api: ApiContract): HomeMovieContract.Interactor = HomeMovieInteractor(api)

    @Provides
    @PerActivity
    fun provideSearch(api: ApiContract): SearchContract.Interactor = SearchInteractor(api)

    @Provides
    @PerActivity
    fun provideDetail(api: ApiContract): DetailContract.Interactor = DetailInteractor(api)

    @Provides
    @PerActivity
    fun provideMore(api: ApiServiceFirebaseContract): MoreContract.Interactor = MoreInteractor(api)
}