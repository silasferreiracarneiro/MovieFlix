package br.com.silas.carneiro.movieflix.data.config

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

class FirebaseConfig: FirebaseConfigContract {

    override fun database(): DatabaseReference {
        return FirebaseDatabase.getInstance().reference
    }

    override fun authFirebase(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    override fun storage(): FirebaseStorage {
        return FirebaseStorage.getInstance()
    }
}