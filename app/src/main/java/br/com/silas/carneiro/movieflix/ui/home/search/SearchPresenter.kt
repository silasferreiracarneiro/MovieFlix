package br.com.silas.carneiro.movieflix.ui.home.search

import br.com.silas.carneiro.movieflix.ui.base.BasePresenter
import javax.inject.Inject

class SearchPresenter<V: SearchContract.View, I: SearchContract.Interactor>
@Inject constructor(var interactorSplash: I):
    BasePresenter<V, I>(interactorSplash), SearchContract.Presenter<V, I> {
}