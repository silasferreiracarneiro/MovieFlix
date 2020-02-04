package br.com.silas.carneiro.movieflix.di.module

import br.com.silas.carneiro.movieflix.data.config.FirebaseConfigContract
import br.com.silas.carneiro.movieflix.data.firebase.contract.ApiServiceFirebaseContract
import br.com.silas.carneiro.movieflix.data.firebase.model.ApiServiceFirebase
import br.com.silas.carneiro.movieflix.data.network.contract.ApiContract
import br.com.silas.carneiro.movieflix.data.network.service.ApiService
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideApiServiceFirebase(api: FirebaseConfigContract): ApiServiceFirebaseContract {
        return ApiServiceFirebase(api)
    }

    @Provides
    fun provideApiServiceNetWork(): ApiContract {
        return ApiService()
    }
}