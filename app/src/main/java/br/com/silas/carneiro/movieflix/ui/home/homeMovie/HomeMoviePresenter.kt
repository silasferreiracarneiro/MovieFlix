package br.com.silas.carneiro.movieflix.ui.home.homeMovie

import br.com.silas.carneiro.movieflix.ui.base.BasePresenter
import javax.inject.Inject

class HomeMoviePresenter<V: HomeMovieContract.View, I: HomeMovieContract.Interactor>
@Inject constructor(var interactorSplash: I):
    BasePresenter<V, I>(interactorSplash), HomeMovieContract.Presenter<V, I> {



}