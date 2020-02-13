package br.com.silas.carneiro.movieflix.data.network.model

import com.google.gson.annotations.SerializedName

data class TrailerResponse (

	@SerializedName("id") val id : Int,
	@SerializedName("results") val results : List<TrailerResultResponse>
)