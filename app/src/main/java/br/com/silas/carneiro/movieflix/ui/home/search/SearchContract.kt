package br.com.silas.carneiro.movieflix.ui.home.search

import br.com.silas.carneiro.movieflix.data.network.model.MovieResponse
import br.com.silas.carneiro.movieflix.ui.base.MvpInteractor
import br.com.silas.carneiro.movieflix.ui.base.MvpPresenter
import br.com.silas.carneiro.movieflix.ui.base.MvpView

interface SearchContract {

    interface View: MvpView {
        fun setListMovie(list: MovieResponse)
    }

    interface Presenter<V: View, I: Interactor>: MvpPresenter<V, I> {
        fun searchMovie(text: String)
    }

    interface Interactor : MvpInteractor {
        suspend fun searchMovie(text: String): MovieResponse?
    }
}