package br.com.silas.carneiro.movieflix.ui.home.more

import br.com.silas.carneiro.movieflix.ui.base.BasePresenter
import javax.inject.Inject

class MorePresenter<V: MoreContract.View, I: MoreContract.Interactor>
@Inject constructor(var interactorMore: I):
    BasePresenter<V, I>(interactorMore), MoreContract.Presenter<V, I> {

    override fun logout() {
        interactorMore.logout(onSucess = {
            getMvpView().showMessage(it)
        }, onError = {
            getMvpView().showMessage(it)
        })
    }

}