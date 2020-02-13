package br.com.silas.carneiro.movieflix.ui.home.search

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.silas.carneiro.movieflix.R
import br.com.silas.carneiro.movieflix.data.network.model.MovieResponse
import br.com.silas.carneiro.movieflix.ui.base.BaseBottomSheetDialogFragment
import br.com.silas.carneiro.movieflix.ui.detail.DetailActivity
import br.com.silas.carneiro.movieflix.utils.AppConstant
import br.com.silas.carneiro.movieflix.utils.RecyclerViewItemClickListener
import kotlinx.android.synthetic.main.fragment_more.close_imageview
import kotlinx.android.synthetic.main.fragment_search.view.*
import javax.inject.Inject

class SearchFragment : BaseBottomSheetDialogFragment(), SearchContract.View {

    @Inject
    lateinit var presenter: SearchContract.Presenter<SearchContract.View, SearchContract.Interactor>

    private lateinit var movie: MovieResponse
    private var recycler: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        val component = getActivityComponent()

        if(component != null){
            component.inject(this)
            presenter.onAttach(this)
        }

        setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogTheme)

        recycler = view.findViewById(R.id.resultSearch) as RecyclerView

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

        configureClickRecycler()

        return view
    }

    private fun configureClickRecycler() {
        context?.let { contexto ->
            recycler?.let {
                it.addOnItemTouchListener(
                    RecyclerViewItemClickListener(
                        contexto,
                        it,
                        object : RecyclerViewItemClickListener.OnItemClickListener {
                            override fun onItemClick(view: View, position: Int) {
                                val item = movie.results[position]
                                val intent = Intent(context, DetailActivity::class.java)
                                intent.putExtra(AppConstant.ITEM_SEARCH_MOVIE, item)
                                startActivity(intent)
                            }

                            override fun onItemLongClick(view: View?, position: Int) {

                            }
                        })
                )
            }
        }
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
        this.movie = movie
        recycler?.setHasFixedSize(true)
        recycler?.layoutManager = LinearLayoutManager(activity)
        recycler?.isNestedScrollingEnabled = false
        recycler?.adapter = SearchAdapter(movie)
        ((recycler?.adapter as SearchAdapter).notifyDataSetChanged())
    }
}