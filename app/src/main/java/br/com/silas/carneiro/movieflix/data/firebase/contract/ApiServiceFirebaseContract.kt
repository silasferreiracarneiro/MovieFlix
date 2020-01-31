package br.com.silas.carneiro.movieflix.data.firebase.contract

import br.com.silas.carneiro.movieflix.domain.User

interface ApiServiceFirebaseContract {

    fun saveUser(user: User, onSucess: (message: String) -> Unit, onError: (message: String) -> Unit)
    fun loginUser(user: User, onSucess: () -> Unit, onError: () -> Unit)
}