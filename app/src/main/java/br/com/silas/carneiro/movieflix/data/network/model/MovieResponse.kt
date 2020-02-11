package br.com.silas.carneiro.movieflix.data.network.model

import com.google.gson.annotations.SerializedName

class MovieResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("results") val results: ArrayList<MovieResultResponse>
)