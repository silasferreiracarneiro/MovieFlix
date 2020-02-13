package br.com.silas.carneiro.movieflix.data.network.service

import br.com.silas.carneiro.movieflix.data.base.BaseRepository
import br.com.silas.carneiro.movieflix.data.config.RetrofitConfig
import br.com.silas.carneiro.movieflix.data.network.contract.ApiContract
import br.com.silas.carneiro.movieflix.data.network.model.DetailMovieResponse
import br.com.silas.carneiro.movieflix.data.network.model.MovieResponse
import br.com.silas.carneiro.movieflix.data.network.model.TrailerResponse
import br.com.silas.carneiro.movieflix.utils.AppConstant

class ApiService: BaseRepository(), ApiContract {

    private var service: RetrofitConfig = RetrofitConfig()

    private val languagePortuguese = "pt_BR"
    private val languageEnglish = "en-US"

    override suspend fun searchMovie(text: String): MovieResponse? {

        return safeApiCall(
            call = {
                service.api.getMovie(
                AppConstant.API_KEY,
                languagePortuguese,
                text,
                1
            ).await() },
            errorMessage = "Erro ao buscar os filmes!"
        )
    }

    override suspend fun getDetailMovie(id: Int): DetailMovieResponse? {
        return safeApiCall(
            call = {
                service.api.getDetailMovie(
                    id,
                    AppConstant.API_KEY,
                    languagePortuguese
                ).await()
            },
            errorMessage = "Erro ao buscar o detalhe do filme!"
        )
    }

    override suspend fun getTrailer(id: Int): TrailerResponse? {
        return safeApiCall(
            call = {
                service.api.getTrailer(
                    id,
                    "videos",
                    AppConstant.API_KEY,
                    languageEnglish
                ).await()
            },
            errorMessage = "Erro ao buscar os trailers do filme!"
        )
    }
}