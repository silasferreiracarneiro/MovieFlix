package br.com.silas.carneiro.movieflix.ui.home.homeMovie

import br.com.silas.carneiro.movieflix.ui.base.MvpInteractor
import br.com.silas.carneiro.movieflix.ui.base.MvpPresenter
import br.com.silas.carneiro.movieflix.ui.base.MvpView

interface HomeMovieContract {

    interface View : MvpView {

    }

    interface Presenter<V: View, I: Interactor>: MvpPresenter<V, I> {

    }

    interface Interactor : MvpInteractor {

    }
}