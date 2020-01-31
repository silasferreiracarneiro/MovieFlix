package br.com.silas.carneiro.movieflix.ui.base

import br.com.silas.carneiro.movieflix.R

open class BasePresenter<V : MvpView, I : MvpInteractor>(val interactor: I): MvpPresenter<V, I>  {

    private lateinit var view: V

    override fun getMvpView(): V {
        return view
    }

    override fun getMvpInteractor(): I {
        return interactor
    }

    override fun handleApiError(error: Exception) {
        if(error != null){
            getMvpView().showMessage(R.string.error_default)
            return
        }
    }

    override fun onAttach(mvpView: V) {
        this.view = mvpView
    }

    override fun isViewAttached(): Boolean {
        return this.view != null
    }

    override fun checkViewAttached() {
        if (!isViewAttached()) throw MvpViewNotAttachedException()
    }

    class MvpViewNotAttachedException : RuntimeException("Please call Presenter.onAttach(MvpView) before" + " requesting data to the Presenter")
}