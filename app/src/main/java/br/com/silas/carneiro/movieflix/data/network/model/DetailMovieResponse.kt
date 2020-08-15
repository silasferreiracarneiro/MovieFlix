package br.com.silas.carneiro.movieflix.data.network.model

import com.google.gson.annotations.SerializedName
import java.util.*


data class DetailMovieResponse (

    @SerializedName("adult") val adult : Boolean,
    @SerializedName("backdrop_path") val backdrop_path : String,
    @SerializedName("belongs_to_collection") val belongs_to_collectionResponse : BelongsToCollectionResponse?,
    @SerializedName("budget") val budget : Int,
    @SerializedName("genres") val genres : List<GenresResponse>,
    @SerializedName("homepage") val homepage : String,
    @SerializedName("id") val id : Int,
    @SerializedName("imdb_id") val imdb_id : String,
    @SerializedName("original_language") val original_language : String,
    @SerializedName("original_title") val original_title : String,
    @SerializedName("overview") val overview : String,
    @SerializedName("popularity") val popularity : Double,
    @SerializedName("poster_path") val poster_path : String,
    @SerializedName("production_companyResponses") val production_companyResponses : List<ProductionCompaniesResponse>,
    @SerializedName("production_countries") val production_countries : List<ProductionCountriesResponse>,
    @SerializedName("release_date") val release_date : Date,
    @SerializedName("revenue") val revenue : Int,
    @SerializedName("runtime") val runtime : Int,
    @SerializedName("spoken_languages") val spoken_languages : List<SpokenLanguagesResponse>,
    @SerializedName("status") val status : String,
    @SerializedName("tagline") val tagline : String,
    @SerializedName("title") val title : String,
    @SerializedName("video") val video : Boolean,
    @SerializedName("vote_average") val vote_average : Double,
    @SerializedName("vote_count") val vote_count : Int
)