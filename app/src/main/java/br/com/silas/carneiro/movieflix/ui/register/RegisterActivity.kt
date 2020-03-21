package br.com.silas.carneiro.movieflix.ui.register

import android.os.Bundle
import android.view.View
import br.com.silas.carneiro.movieflix.R
import br.com.silas.carneiro.movieflix.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class RegisterActivity : BaseActivity(), RegisterContract.View {

    @Inject
    lateinit var presenter : RegisterContract.Presenter<RegisterContract.View, RegisterContract.Interactor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        getActivityComponent().inject(this)
        presenter.onAttach(this)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.title = getString(R.string.title_registry)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    override fun getAccountList() {
        //startActivity(Intent(this, AccountListActivity::class.java))
    }

    fun saveProfile(view: View){
        val name = edtNome?.text.toString()
        val email = edtEmail?.text.toString()
        val password = extPassword?.text.toString()

        this.presenter.register(name, email, password)
    }
}
