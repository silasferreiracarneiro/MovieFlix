package br.com.silas.carneiro.movieflix.data.firebase.contract

import br.com.silas.carneiro.movieflix.domain.User

interface ApiServiceFirebaseContract {

    fun saveUser(user: User)
    fun loginUser(user: User)
}