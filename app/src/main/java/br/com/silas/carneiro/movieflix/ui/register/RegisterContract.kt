package br.com.silas.carneiro.movieflix.ui.register

import br.com.silas.carneiro.movieflix.domain.User
import br.com.silas.carneiro.movieflix.ui.base.MvpInteractor
import br.com.silas.carneiro.movieflix.ui.base.MvpPresenter
import br.com.silas.carneiro.movieflix.ui.base.MvpView

interface RegisterContract {

    interface View: MvpView {
        fun getAccountList()
    }

    interface Presenter<V: View, I: Interactor>: MvpPresenter<V, I> {
        fun register(name: String, email: String, password: String)
    }

    interface Interactor: MvpInteractor {
        fun register(user: User, onSucess: (message: String) -> Unit, onError: (message: String) -> Unit)
    }
}