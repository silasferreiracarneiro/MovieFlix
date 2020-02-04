package br.com.silas.carneiro.movieflix.ui.splash

import br.com.silas.carneiro.movieflix.data.firebase.contract.ApiServiceFirebaseContract
import br.com.silas.carneiro.movieflix.data.prefs.PreferencesHelper
import br.com.silas.carneiro.movieflix.ui.base.BaseInteractor
import com.google.firebase.auth.FirebaseUser

class SplashInteractor(var firebaseApi: ApiServiceFirebaseContract, var prefes: PreferencesHelper): BaseInteractor(), SplashContract.Interactor {

    override fun getFirstAccess(): Boolean {
        return prefes.getFirstLogin()
    }

    override fun getUserLogin(onSucess: (user: FirebaseUser) -> Unit, onError: (message: String) -> Unit) {
        firebaseApi.loggedIn(onSucess, onError)
    }
}