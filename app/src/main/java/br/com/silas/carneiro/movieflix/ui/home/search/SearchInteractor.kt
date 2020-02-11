package br.com.silas.carneiro.movieflix.ui.home.search

import br.com.silas.carneiro.movieflix.data.network.contract.ApiContract
import br.com.silas.carneiro.movieflix.data.network.model.MovieResponse

class SearchInteractor(var api: ApiContract) : SearchContract.Interactor {

    override suspend fun searchMovie(text: String): MovieResponse? {
        return api.searchMovie(text)
    }
}