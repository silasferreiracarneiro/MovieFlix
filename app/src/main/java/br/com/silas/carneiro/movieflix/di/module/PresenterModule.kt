package br.com.silas.carneiro.movieflix.di.module

import androidx.appcompat.app.AppCompatActivity
import br.com.silas.carneiro.movieflix.di.PerActivity
import br.com.silas.carneiro.movieflix.ui.login.LoginContract
import br.com.silas.carneiro.movieflix.ui.login.LoginPresenter
import br.com.silas.carneiro.movieflix.ui.register.RegisterContract
import br.com.silas.carneiro.movieflix.ui.register.RegisterPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule(var appCompatActivity: AppCompatActivity) {

    @Provides
    @PerActivity
    fun provideRegister(interactorRegister: RegisterContract.Interactor):
            RegisterContract.Presenter<RegisterContract.View, RegisterContract.Interactor> = RegisterPresenter(interactorRegister)

    @Provides
    @PerActivity
    fun provideLogin(interactor: LoginContract.Interactor):
            LoginContract.Presenter<LoginContract.View, LoginContract.Interactor> =  LoginPresenter(interactor)

}