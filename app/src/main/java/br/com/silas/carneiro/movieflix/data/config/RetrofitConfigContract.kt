package br.com.silas.carneiro.movieflix.data.config

import br.com.silas.carneiro.movieflix.data.network.service.ApiService

interface RetrofitConfigContract {
    var api: ApiService
}