package br.com.silas.carneiro.movieflix.ui.home.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.silas.carneiro.movieflix.R
import br.com.silas.carneiro.movieflix.data.network.model.MovieResponse
import br.com.silas.carneiro.movieflix.ui.base.BaseBottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_more.*
import kotlinx.android.synthetic.main.fragment_search.view.*
import javax.inject.Inject

class SearchFragment : BaseBottomSheetDialogFragment(), SearchContract.View {

    @Inject
    lateinit var presenter: SearchContract.Presenter<SearchContract.View, SearchContract.Interactor>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        val component = getActivityComponent()

        if(component != null){
            component.inject(this)
            presenter.onAttach(this)
        }

        setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogTheme)

        view.resultSearch.setHasFixedSize(true)
        view.resultSearch.layoutManager = LinearLayoutManager(activity)
        view.resultSearch.isNestedScrollingEnabled = false

        view.search.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    if(it.length >= 3){
                        presenter.searchMovie(it)
                    }
                }
                return true
            }
        })

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        close_imageview.setOnClickListener {
            this.dismiss()
        }
    }

    override fun setUp(view: View) {

    }

    override fun setListMovie(movie: MovieResponse) {
        view?.resultSearch?.adapter = SearchAdapter(movie)
        (view?.resultSearch?.adapter as SearchAdapter).notifyDataSetChanged()
    }


}