package br.com.silas.carneiro.movieflix.data.firebase.model

import android.util.Log
import br.com.silas.carneiro.movieflix.data.base.BaseRepository
import br.com.silas.carneiro.movieflix.data.config.FirebaseConfigContract
import br.com.silas.carneiro.movieflix.data.firebase.contract.ApiServiceFirebaseContract
import br.com.silas.carneiro.movieflix.domain.User
import br.com.silas.carneiro.movieflix.utils.AppConstant.Companion.USER
import br.com.silas.carneiro.movieflix.utils.Base64Util
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.FirebaseUser
import java.lang.Exception

class ApiServiceFirebase(var firebaseConfig: FirebaseConfigContract): ApiServiceFirebaseContract {

    override fun saveUser(user: User, onSucess: (message: String) -> Unit, onError: (message: String) -> Unit) {
        firebaseConfig.database().child(USER).child(Base64Util.encode(user.email)).setValue(user).addOnCompleteListener{
            if(it.isSuccessful) {
                this.createUserInAuthentication(user, onSucess, onError)
            }else {
                Log.e("ERRO SAVAR USUÁRIO", it.exception.toString())
                onError("Erro ao salvar o usuário!")
            }
        }
    }

    private fun createUserInAuthentication(user: User, onSucess: (message: String) -> Unit, onError: (message: String) -> Unit) {
        firebaseConfig.authFirebase().createUserWithEmailAndPassword(user.email, user.password).addOnCompleteListener {
            if(it.isSuccessful) {
                onSucess("Usuário cadastrado com sucesso!")
            }else{
                Log.e("ERRO SALVAR USUÁRIO", it.exception.toString())
                val messageUser = when (it.exception) {
                    is FirebaseAuthWeakPasswordException -> "Digite uma senha mais forte!"
                    is FirebaseAuthInvalidCredentialsException -> "Por favor, digite um e-mail válido!"
                    is FirebaseAuthUserCollisionException -> "Esta conta já foi cadastrada!"
                    else -> "Erro ao cadastrar a conta!"
                }
                onError(messageUser)
            }
        }
    }

    override fun loginUser(user: User, onSucess: (user: FirebaseUser) -> Unit, onError: (message: String) -> Unit) {
        firebaseConfig.authFirebase().signInWithEmailAndPassword(user.email, user.password).addOnCompleteListener{
            if(it.isSuccessful){
                it.result?.user?.let { user ->
                    onSucess(user)
                }
            } else {
                onError("Erro ao logar com o usuário")
            }
        }
    }

    override fun loggedIn(onSucess: (user: FirebaseUser) -> Unit, onError: (message: String) -> Unit) {
        try {
            val currentUser = firebaseConfig.authFirebase().currentUser
            currentUser?.let {
                onSucess(it)
                return
            }
            onError("Faça o login novamente!")
        }catch (e: Exception){
            e.printStackTrace()
            onError("Faça o login novamente!")
        }
    }

    override fun signOut(onSucess: (message: String) -> Unit, onError: (message: String) -> Unit) {
        try {
            firebaseConfig.authFirebase().signOut()
            onSucess("Deslogado com sucesso")
        }catch (e: Exception){
            e.printStackTrace()
            onError("Erro ao deslogar o usuário")
        }
    }
}