package br.com.silas.carneiro.movieflix.ui.login

import br.com.silas.carneiro.movieflix.domain.User
import br.com.silas.carneiro.movieflix.ui.base.BasePresenter
import javax.inject.Inject

class LoginPresenter<V: LoginContract.View, I: LoginContract.Interactor>
@Inject constructor(var interactorLogin: I):
    BasePresenter<V, I>(interactorLogin), LoginContract.Presenter<V, I> {

    override fun login(email: String, password: String) {
        if(validateLogin(email, password)){

            var user = User()
            user.email = email
            user.password = password

            this.interactorLogin.login(user, onSucess = {

            }, onError = {

            })
        }
    }

    private fun validateLogin(email: String, password: String): Boolean {
        return true
    }
}