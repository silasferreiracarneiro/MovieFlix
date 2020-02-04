package br.com.silas.carneiro.movieflix.ui.splash

import br.com.silas.carneiro.movieflix.ui.base.MvpInteractor
import br.com.silas.carneiro.movieflix.ui.base.MvpPresenter
import br.com.silas.carneiro.movieflix.ui.base.MvpView
import com.google.firebase.auth.FirebaseUser

interface SplashContract {

    interface View: MvpView {
        fun goToHome()
        fun goToLogin()
        fun goToCaroussel()
    }

    interface Presenter<V: View, I: Interactor>: MvpPresenter<V, I> {
        fun goToActivity()
    }

    interface Interactor: MvpInteractor {
        fun getFirstAccess(): Boolean
        fun getUserLogin(onSucess: (user: FirebaseUser) -> Unit, onError: (message: String) -> Unit)
    }
}