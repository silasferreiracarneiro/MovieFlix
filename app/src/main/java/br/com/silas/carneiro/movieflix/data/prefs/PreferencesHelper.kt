package br.com.silas.carneiro.movieflix.data.prefs

import br.com.silas.carneiro.movieflix.domain.User

interface PreferencesHelper {

    fun getUser()
    fun savedUser(user: User, onSucess: () -> Unit, onError: () -> Unit)
    fun getFirstLogin(): Boolean
    fun setFirstLogin(firstLogin: Boolean)
}