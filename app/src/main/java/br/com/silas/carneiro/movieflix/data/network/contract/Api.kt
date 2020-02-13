package br.com.silas.carneiro.movieflix.data.network.contract

import br.com.silas.carneiro.movieflix.data.network.model.DetailMovieResponse
import br.com.silas.carneiro.movieflix.data.network.model.MovieResponse
import br.com.silas.carneiro.movieflix.data.network.model.TrailerResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("search/movie")
    fun getMovie(
        @Query("api_key") key: String,
        @Query("language") language: String,
        @Query("query") text: String,
        @Query("page") page: Int
    ): Deferred<Response<MovieResponse>>

    @Headers("Content-Type: application/json")
    @GET("/3/movie/{id}")
    fun getDetailMovie(
        @Path("id") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Deferred<Response<DetailMovieResponse>>


    @Headers("Content-Type: application/json")
    @GET("/3/movie/{id}")
    fun getTrailer(
        @Path("id") movieId: Int,
        @Query("videos") videos: String,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Deferred<Response<TrailerResponse>>
}