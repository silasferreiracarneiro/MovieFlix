package br.com.silas.carneiro.movieflix.ui.caroussel

import br.com.silas.carneiro.movieflix.ui.base.MvpInteractor
import br.com.silas.carneiro.movieflix.ui.base.MvpPresenter
import br.com.silas.carneiro.movieflix.ui.base.MvpView

interface CarousselContract {

    interface View: MvpView {
        fun setFirstLogin(isLogged: Boolean)
    }

    interface Presenter<V: CarousselContract.View, I: CarousselContract.Interactor>: MvpPresenter<V, I> {
        fun setFirstLogin(isLogged: Boolean)
    }

    interface Interactor: MvpInteractor {
        fun setFirstLogin(isLogged: Boolean)
    }
}