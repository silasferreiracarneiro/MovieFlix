package br.com.silas.carneiro.movieflix.ui.home.more

import br.com.silas.carneiro.movieflix.data.firebase.contract.ApiServiceFirebaseContract

class MoreInteractor(var api: ApiServiceFirebaseContract): MoreContract.Interactor {

    override fun logout(onSucess: (String) -> Unit, onError: (String) -> Unit) {
        api.signOut(onSucess, onError)
    }
}