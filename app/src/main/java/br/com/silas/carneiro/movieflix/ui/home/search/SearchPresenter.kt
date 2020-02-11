package br.com.silas.carneiro.movieflix.ui.home.search

import br.com.silas.carneiro.movieflix.ui.base.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchPresenter<V: SearchContract.View, I: SearchContract.Interactor>
@Inject constructor(var interactorSearch: I):
    BasePresenter<V, I>(interactorSearch), SearchContract.Presenter<V, I> {

    override fun searchMovie(text: String) {

        CoroutineScope(Dispatchers.IO).launch {
            val movie = interactorSearch.searchMovie(text)
            withContext(Dispatchers.Main) {
                if(movie != null) {
                    getMvpView().setListMovie(movie)
                }else{
                    getMvpView().showMessage("Erro ao buscar os filmes!")
                }
            }
        }
    }
}