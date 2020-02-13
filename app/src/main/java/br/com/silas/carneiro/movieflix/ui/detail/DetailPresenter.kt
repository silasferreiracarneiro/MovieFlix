package br.com.silas.carneiro.movieflix.ui.detail

import br.com.silas.carneiro.movieflix.ui.base.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DetailPresenter<V: DetailContract.View, I: DetailContract.Interactor>
@Inject constructor(var interactorDetail: I):
BasePresenter<V, I>(interactorDetail), DetailContract.Presenter<V, I> {

    override fun getTrailers(id: Int) {

        CoroutineScope(Dispatchers.IO).launch {
            val trailers = interactorDetail.getTrailers(id)
            withContext(Dispatchers.Main) {
                if(trailers != null) {
                    getMvpView().setTrailers(trailers)
                }else{
                    getMvpView().showMessage("Erro ao buscar os trailers do filme!")
                    getMvpView().onFinish()
                }
            }
        }
    }

    override fun getDetailMovie(id: Int) {

        CoroutineScope(Dispatchers.IO).launch {
            val movie = interactorDetail.getDetailMovie(id)
            withContext(Dispatchers.Main) {
                if(movie != null) {
                    getMvpView().setMovieDetail(movie)
                }else{
                    getMvpView().showMessage("Erro ao buscar o detalhe do filme!")
                    getMvpView().onFinish()
                }
            }
        }
    }
}