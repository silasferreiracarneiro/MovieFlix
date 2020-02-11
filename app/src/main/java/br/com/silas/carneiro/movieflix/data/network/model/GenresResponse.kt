package br.com.silas.carneiro.movieflix.data.network.model

import com.google.gson.annotations.SerializedName

class GenresResponse(
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String?
) {
}