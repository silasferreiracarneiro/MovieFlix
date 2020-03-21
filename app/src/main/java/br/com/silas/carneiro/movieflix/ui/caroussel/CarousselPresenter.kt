package br.com.silas.carneiro.movieflix.ui.caroussel

import br.com.silas.carneiro.movieflix.ui.base.BasePresenter
import javax.inject.Inject

class CarousselPresenter<V: CarousselContract.View, I: CarousselContract.Interactor>
@Inject constructor(var interactorCaroussel: I):
    BasePresenter<V, I>(interactorCaroussel), CarousselContract.Presenter<V, I> {

    override fun setFirstLogin(isLogged: Boolean) {
        interactorCaroussel.setFirstLogin(isLogged)
    }
}