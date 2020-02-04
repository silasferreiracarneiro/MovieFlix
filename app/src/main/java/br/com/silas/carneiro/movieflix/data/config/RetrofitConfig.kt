package br.com.silas.carneiro.movieflix.data.config

import br.com.silas.carneiro.movieflix.data.network.service.ApiService
import br.com.silas.carneiro.movieflix.utils.AppConstant.Companion.URL_BASE
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig: RetrofitConfigContract {

    fun getIntanceRetrofit() = Retrofit.Builder()
        .baseUrl(URL_BASE)
        .client(OkHttpClient().newBuilder().build())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    override var api: ApiService = getIntanceRetrofit().create(
        ApiService::class.java)
}