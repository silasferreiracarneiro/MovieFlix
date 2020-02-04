package br.com.silas.carneiro.movieflix.ui.register

import br.com.silas.carneiro.movieflix.domain.User
import br.com.silas.carneiro.movieflix.ui.base.BasePresenter
import javax.inject.Inject

class RegisterPresenter<V: RegisterContract.View, I: RegisterContract.Interactor>
@Inject constructor(var interactorRegister: I):
BasePresenter<V, I>(interactorRegister), RegisterContract.Presenter<V, I> {

    override fun register(name: String, email: String, password: String) {

        val user = User()
        user.name = name
        user.email = email
        user.password = password

        if (validateUser(user)) {
            this.interactorRegister.register(user, onSucess = {
                getMvpView().showMessage(it)
                getMvpView().onFinish()
            }, onError = {
                getMvpView().showMessage(it)
            })
        }
    }

    private fun validateUser(user: User): Boolean {
        return true
    }
}