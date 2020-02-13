package br.com.silas.carneiro.movieflix.data.network.contract

import br.com.silas.carneiro.movieflix.data.network.model.DetailMovieResponse
import br.com.silas.carneiro.movieflix.data.network.model.MovieResponse
import br.com.silas.carneiro.movieflix.data.network.model.TrailerResponse
import java.util.ArrayList

interface ApiContract {
    suspend fun searchMovie(text: String): MovieResponse?
    suspend fun getDetailMovie(id: Int): DetailMovieResponse?
    suspend fun getTrailer(id: Int): TrailerResponse?
}