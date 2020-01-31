package br.com.silas.carneiro.movieflix.data.config

import br.com.silas.carneiro.movieflix.data.network.ApiService

interface RetrofitConfigContract {
    val api: ApiService
}