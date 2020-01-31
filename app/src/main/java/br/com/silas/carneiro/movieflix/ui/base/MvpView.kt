package br.com.silas.carneiro.movieflix.ui.base

interface MvpView {

    abstract fun showLoading()

    abstract fun hideLoading()

    abstract fun showMessage(message: String)

    abstract fun showMessage(id: Int)

    abstract fun onGetString(id: Int): String

    abstract fun onFinish()

    abstract fun isNetworkConnected(): Boolean
}