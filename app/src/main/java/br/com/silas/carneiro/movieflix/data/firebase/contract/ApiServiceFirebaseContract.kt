package br.com.silas.carneiro.movieflix.data.firebase.contract

import br.com.silas.carneiro.movieflix.domain.User
import com.google.firebase.auth.FirebaseUser

interface ApiServiceFirebaseContract {

    fun saveUser(user: User, onSucess: (message: String) -> Unit, onError: (message: String) -> Unit)
    fun loginUser(user: User, onSucess: (user: FirebaseUser) -> Unit, onError: (message: String) -> Unit)
    fun loggedIn(onSucess: (user: FirebaseUser) -> Unit, onError: (message: String) -> Unit)
    fun signOut(onSucess: (message: String) -> Unit, onError: (message: String) -> Unit)
}