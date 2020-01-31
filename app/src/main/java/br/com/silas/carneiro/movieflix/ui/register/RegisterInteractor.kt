package br.com.silas.carneiro.movieflix.ui.register

import br.com.silas.carneiro.movieflix.data.firebase.contract.ApiServiceFirebaseContract
import br.com.silas.carneiro.movieflix.domain.User
import br.com.silas.carneiro.movieflix.ui.base.BaseInteractor

class RegisterInteractor(var firebaseApi: ApiServiceFirebaseContract): BaseInteractor(), RegisterContract.Interactor {

    override fun register(user: User, onSucess: (message: String) -> Unit, onError: (message: String) -> Unit) {
        firebaseApi.saveUser(user, onSucess, onError)
    }
}