package br.com.silas.carneiro.movieflix.data.network.service

import br.com.silas.carneiro.movieflix.data.base.BaseRepository
import br.com.silas.carneiro.movieflix.data.config.RetrofitConfig
import br.com.silas.carneiro.movieflix.data.network.contract.ApiContract
import br.com.silas.carneiro.movieflix.data.network.model.DetailMovieResponse
import br.com.silas.carneiro.movieflix.data.network.model.MovieResponse
import br.com.silas.carneiro.movieflix.utils.AppConstant
import java.util.ArrayList

class ApiService: BaseRepository(), ApiContract {

    private var service: RetrofitConfig = RetrofitConfig()

    private val language = "pt_BR"

    override suspend fun searchMovie(text: String): MovieResponse? {

        return safeApiCall(
            call = {
                service.api.getMovie(
                AppConstant.API_KEY,
                language,
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
                    language
                ).await()
            },
            errorMessage = "Erro ao buscar o detalhe do filme!"
        )
    }
}