package br.com.silas.carneiro.movieflix.ui.detail

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import br.com.silas.carneiro.movieflix.R
import br.com.silas.carneiro.movieflix.data.network.model.DetailMovieResponse
import br.com.silas.carneiro.movieflix.data.network.model.MovieResultResponse
import br.com.silas.carneiro.movieflix.ui.base.BaseActivity
import br.com.silas.carneiro.movieflix.utils.AppConstant
import br.com.silas.carneiro.movieflix.utils.AppConstant.Companion.ITEM_SEARCH_MOVIE
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.toolbar_gradient.*
import javax.inject.Inject

class DetailActivity : BaseActivity(), DetailContract.View {

    @Inject
    lateinit var presenter : DetailContract.Presenter<DetailContract.View, DetailContract.Interactor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        getActivityComponent().inject(this)
        presenter.onAttach(this)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val movie = intent.getSerializableExtra(ITEM_SEARCH_MOVIE) as MovieResultResponse
        presenter.getDetailMovie(movie.id)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun setMovieDetail(movie: DetailMovieResponse) {
        txtTitleDatail.text = movie.title
        setImageBackdrop(movie.backdrop_path)
    }

    private fun setImageBackdrop(url: String) {
        if(url != null && url.isNotBlank() && url.isNotEmpty()){
            val urlImageBackdrop = AppConstant.URL_IMG_DETAIL + url
            Glide.with(this)
                .load(urlImageBackdrop)
                .error(ColorDrawable(Color.RED))
                .into(imageBackdrop)
        }
    }
}
