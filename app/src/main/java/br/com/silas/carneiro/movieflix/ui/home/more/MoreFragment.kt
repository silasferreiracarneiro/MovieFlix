package br.com.silas.carneiro.movieflix.ui.home.more

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.silas.carneiro.movieflix.R
import br.com.silas.carneiro.movieflix.ui.base.BaseBottomSheetDialogFragment
import br.com.silas.carneiro.movieflix.ui.profile.ProfileActivity
import kotlinx.android.synthetic.main.fragment_more.*
import javax.inject.Inject

class MoreFragment : BaseBottomSheetDialogFragment(), MoreContract.View {

    @Inject
    lateinit var presenter: MoreContract.Presenter<MoreContract.View, MoreContract.Interactor>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_more, container, false)

        val component = getActivityComponent()

        if(component != null){
            component.inject(this)
            presenter.onAttach(this)
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        navigation_view.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.logout -> presenter.logout()
                R.id.profile -> startActivity(Intent(context, ProfileActivity::class.java))
            }
             true
        }

        close_imageview.setOnClickListener {
            this.dismiss()
        }
    }

    override fun setUp(view: View) {

    }
}