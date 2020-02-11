package br.com.silas.carneiro.movieflix.data.network.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MovieResultResponse(
    @SerializedName("popularity") val popularity : Double,
    @SerializedName("id") val id : Int,
    @SerializedName("video") val video : Boolean,
    @SerializedName("vote_count") val voteCount : Int,
    @SerializedName("vote_average") val voteAverage : Double,
    @SerializedName("title") val title : String,
    @SerializedName("release_date") val release_date : String,
    @SerializedName("original_language") val originalLanguage : String,
    @SerializedName("original_title") val originalTitle : String,
    @SerializedName("genre_ids") val genreIds : List<Int>,
    @SerializedName("backdrop_path") val backdropPath : String,
    @SerializedName("adult") val adult : Boolean,
    @SerializedName("overview") val overview : String,
    @SerializedName("poster_path") val posterPath : String
) : Serializable