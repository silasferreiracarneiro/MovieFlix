package br.com.silas.carneiro.movieflix.ui.home.search

import br.com.silas.carneiro.movieflix.ui.base.MvpInteractor
import br.com.silas.carneiro.movieflix.ui.base.MvpPresenter
import br.com.silas.carneiro.movieflix.ui.base.MvpView

interface SearchContract {

    interface View: MvpView {

    }

    interface Presenter<V: View, I: Interactor>: MvpPresenter<V, I> {

    }

    interface Interactor : MvpInteractor {

    }
}