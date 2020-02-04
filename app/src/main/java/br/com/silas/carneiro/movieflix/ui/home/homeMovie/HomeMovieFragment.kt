package br.com.silas.carneiro.movieflix.ui.home.homeMovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.silas.carneiro.movieflix.R
import br.com.silas.carneiro.movieflix.ui.base.BaseFragment
import javax.inject.Inject

class HomeMovieFragment : BaseFragment(), HomeMovieContract.View {

    @Inject
    lateinit var presenter : HomeMovieContract.Presenter<HomeMovieContract.View, HomeMovieContract.Interactor>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val component = getActivityComponent()

        if(component != null){
            component.inject(this)
            presenter.onAttach(this)
        }


        return view
    }

    override fun setUp(view: View) {

    }
}