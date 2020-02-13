package br.com.silas.carneiro.movieflix.ui.detail

import br.com.silas.carneiro.movieflix.data.network.contract.ApiContract
import br.com.silas.carneiro.movieflix.data.network.model.DetailMovieResponse
import br.com.silas.carneiro.movieflix.data.network.model.TrailerResponse

class DetailInteractor(var api: ApiContract): DetailContract.Interactor {

    override suspend fun getTrailers(id: Int): TrailerResponse? {
        return api.getTrailer(id)
    }

    override suspend fun getDetailMovie(id: Int): DetailMovieResponse? {
        return api.getDetailMovie(id)
    }
}