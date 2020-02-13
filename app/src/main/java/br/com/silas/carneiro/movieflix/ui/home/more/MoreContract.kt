package br.com.silas.carneiro.movieflix.ui.home.more

import br.com.silas.carneiro.movieflix.ui.base.MvpInteractor
import br.com.silas.carneiro.movieflix.ui.base.MvpPresenter
import br.com.silas.carneiro.movieflix.ui.base.MvpView

interface MoreContract {

    interface View: MvpView {

    }

    interface Presenter<V: View, I: Interactor>: MvpPresenter<V, I> {
        fun logout()
    }

    interface Interactor: MvpInteractor {
        fun logout(onSucess: (String) -> Unit, onError: (String) -> Unit)
    }
}