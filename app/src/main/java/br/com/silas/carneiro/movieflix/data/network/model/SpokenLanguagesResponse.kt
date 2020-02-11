package br.com.silas.carneiro.movieflix.data.network.model

import com.google.gson.annotations.SerializedName

data class SpokenLanguagesResponse (

	@SerializedName("iso_639_1") val iso_639_1 : String?,
	@SerializedName("name") val name : String?
)