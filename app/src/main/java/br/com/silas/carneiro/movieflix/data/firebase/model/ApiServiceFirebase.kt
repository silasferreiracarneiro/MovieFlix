package br.com.silas.carneiro.movieflix.data.firebase.model

import br.com.silas.carneiro.movieflix.data.base.BaseRepository
import br.com.silas.carneiro.movieflix.data.config.FirebaseConfigContract
import br.com.silas.carneiro.movieflix.data.firebase.contract.ApiServiceFirebaseContract
import br.com.silas.carneiro.movieflix.domain.User

class ApiServiceFirebase(var firebaseConfig: FirebaseConfigContract): BaseRepository(), ApiServiceFirebaseContract {

    override fun saveUser(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loginUser(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}