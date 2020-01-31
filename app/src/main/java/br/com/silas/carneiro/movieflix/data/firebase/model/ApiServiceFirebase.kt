package br.com.silas.carneiro.movieflix.data.firebase.model

import android.util.Log
import br.com.silas.carneiro.movieflix.data.base.BaseRepository
import br.com.silas.carneiro.movieflix.data.config.FirebaseConfigContract
import br.com.silas.carneiro.movieflix.data.firebase.contract.ApiServiceFirebaseContract
import br.com.silas.carneiro.movieflix.domain.User
import br.com.silas.carneiro.movieflix.utils.AppConstant.Companion.USER
import br.com.silas.carneiro.movieflix.utils.Base64Util

class ApiServiceFirebase(var firebaseConfig: FirebaseConfigContract): BaseRepository(), ApiServiceFirebaseContract {

    override fun saveUser(user: User, onSucess: (message: String) -> Unit, onError: (message: String) -> Unit) {
        firebaseConfig.database().child(USER).child(Base64Util.encode(user.email)).setValue(user).addOnCompleteListener{
            if(it.isSuccessful){
                onSucess("Usuário cadastrado com sucesso!")
            }else{
                Log.e("ERRO SAVAR USUÁRIO", it.exception.toString())
                onError("Erro ao salvar o usuário!")
            }
        }
    }

    override fun loginUser(user: User, onSucess: () -> Unit, onError: () -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}