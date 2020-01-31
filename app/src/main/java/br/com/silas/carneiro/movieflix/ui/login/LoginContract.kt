package br.com.silas.carneiro.movieflix.ui.login

import br.com.silas.carneiro.movieflix.domain.User
import br.com.silas.carneiro.movieflix.ui.base.MvpInteractor
import br.com.silas.carneiro.movieflix.ui.base.MvpPresenter
import br.com.silas.carneiro.movieflix.ui.base.MvpView

interface LoginContract {

    interface View: MvpView {
        fun goHome()
    }

    interface Presenter<V: LoginContract.View, I: LoginContract.Interactor>: MvpPresenter<V, I> {
        fun login(email: String, password: String)
    }

    interface Interactor: MvpInteractor {
        fun login(user: User, onSucess: () -> Unit, onError: () -> Unit)
    }
}