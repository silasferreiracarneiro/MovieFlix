package br.com.silas.carneiro.movieflix.ui.login

import br.com.silas.carneiro.movieflix.data.firebase.contract.ApiServiceFirebaseContract
import br.com.silas.carneiro.movieflix.data.prefs.PreferencesHelper
import br.com.silas.carneiro.movieflix.domain.User
import br.com.silas.carneiro.movieflix.ui.base.BaseInteractor
import com.google.firebase.auth.FirebaseUser

class LoginInteractor(var firebaseApi: ApiServiceFirebaseContract, var prefsApi: PreferencesHelper): BaseInteractor(), LoginContract.Interactor {

    override fun saveUserPrefes(user: User, onSucess: () -> Unit, onError: () -> Unit) {
        prefsApi.savedUser(user, onSucess, onError)
    }

    override fun login(user: User, onSucess: (user: FirebaseUser) -> Unit, onError: (message: String) -> Unit) {
        this.firebaseApi.loginUser(user, onSucess, onError)
    }
}