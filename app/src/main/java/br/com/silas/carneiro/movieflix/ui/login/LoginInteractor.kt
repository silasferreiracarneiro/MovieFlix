package br.com.silas.carneiro.movieflix.ui.login

import br.com.silas.carneiro.movieflix.data.firebase.contract.ApiServiceFirebaseContract
import br.com.silas.carneiro.movieflix.domain.User
import br.com.silas.carneiro.movieflix.ui.base.BaseInteractor

class LoginInteractor(var firebaseApi: ApiServiceFirebaseContract): BaseInteractor(), LoginContract.Interactor {

    override fun login(user: User, onSucess: () -> Unit, onError: () -> Unit) {
        this.firebaseApi.loginUser(user, onSucess, onError)
    }
}