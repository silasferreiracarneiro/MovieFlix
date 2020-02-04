package br.com.silas.carneiro.movieflix.ui.splash

import br.com.silas.carneiro.movieflix.ui.base.BasePresenter
import javax.inject.Inject

class SplashPresenter<V: SplashContract.View, I: SplashContract.Interactor>
@Inject constructor(var interactorSplash: I):
    BasePresenter<V, I>(interactorSplash), SplashContract.Presenter<V, I> {

    override fun goToActivity() {
        if(interactorSplash.getFirstAccess()){
            getMvpView().goToCaroussel()
        }else{
            loggedInUser()
        }
    }

    private fun loggedInUser() {
        interactorSplash.getUserLogin(onSucess = {
            getMvpView().goToHome()
        }, onError = {
            getMvpView().showMessage(it)
            getMvpView().goToLogin()
        })
    }
}