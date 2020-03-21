package br.com.silas.carneiro.movieflix.ui.caroussel

import br.com.silas.carneiro.movieflix.data.prefs.PreferencesHelper

class CarousselInteract(var prefsApi: PreferencesHelper):  CarousselContract.Interactor {

    override fun setFirstLogin(isLogged: Boolean) {
        prefsApi.setFirstLogin(isLogged)
    }
}