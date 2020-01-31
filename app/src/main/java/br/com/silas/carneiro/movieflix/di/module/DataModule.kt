package br.com.silas.carneiro.movieflix.di.module

import androidx.appcompat.app.AppCompatActivity
import br.com.silas.carneiro.movieflix.data.config.FirebaseConfigContract
import br.com.silas.carneiro.movieflix.data.firebase.contract.ApiServiceFirebaseContract
import br.com.silas.carneiro.movieflix.data.firebase.model.ApiServiceFirebase
import dagger.Module
import dagger.Provides

@Module
class DataModule(var appCompatActivity: AppCompatActivity) {

    @Provides
    fun provideApiService(api: FirebaseConfigContract): ApiServiceFirebaseContract {
        return ApiServiceFirebase(api)
    }
}