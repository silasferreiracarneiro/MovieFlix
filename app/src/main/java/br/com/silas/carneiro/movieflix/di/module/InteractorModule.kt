package br.com.silas.carneiro.movieflix.di.module

import androidx.appcompat.app.AppCompatActivity
import br.com.silas.carneiro.movieflix.data.firebase.contract.ApiServiceFirebaseContract
import br.com.silas.carneiro.movieflix.di.PerActivity
import br.com.silas.carneiro.movieflix.ui.login.LoginContract
import br.com.silas.carneiro.movieflix.ui.login.LoginInteractor
import br.com.silas.carneiro.movieflix.ui.register.RegisterContract
import br.com.silas.carneiro.movieflix.ui.register.RegisterInteractor
import dagger.Module
import dagger.Provides

@Module
class InteractorModule(var appCompatActivity: AppCompatActivity) {

    @Provides
    @PerActivity
    fun provideRegister(api: ApiServiceFirebaseContract): RegisterContract.Interactor = RegisterInteractor(api)

    @Provides
    @PerActivity
    fun provideLogin(api: ApiServiceFirebaseContract): LoginContract.Interactor = LoginInteractor(api)
}