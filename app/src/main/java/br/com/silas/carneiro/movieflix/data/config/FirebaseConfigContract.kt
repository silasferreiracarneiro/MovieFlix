package br.com.silas.carneiro.movieflix.data.config

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.FirebaseStorage

interface FirebaseConfigContract {

    fun database() : DatabaseReference
    fun authFirebase(): FirebaseAuth
    fun storage(): FirebaseStorage
}