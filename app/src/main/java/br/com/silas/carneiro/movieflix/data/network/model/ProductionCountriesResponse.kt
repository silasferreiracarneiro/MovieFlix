package br.com.silas.carneiro.movieflix.data.network.model

import com.google.gson.annotations.SerializedName

data class ProductionCountriesResponse (

	@SerializedName("iso_3166_1") val iso_3166_1 : String?,
	@SerializedName("name") val name : String?
)