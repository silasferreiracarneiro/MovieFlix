package br.com.silas.carneiro.movieflix.ui.detail

import br.com.silas.carneiro.movieflix.data.network.model.DetailMovieResponse
import br.com.silas.carneiro.movieflix.ui.base.MvpInteractor
import br.com.silas.carneiro.movieflix.ui.base.MvpPresenter
import br.com.silas.carneiro.movieflix.ui.base.MvpView

interface DetailContract {

    interface View: MvpView {
        fun setMovieDetail(movie: DetailMovieResponse)
    }

    interface Presenter<V: View, I: Interactor>: MvpPresenter<V, I> {
        fun getDetailMovie(id: Int)
    }

    interface Interactor: MvpInteractor {
        suspend fun getDetailMovie(id: Int): DetailMovieResponse?
    }
}