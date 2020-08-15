package br.com.silas.carneiro.movieflix.ui.login

import android.content.Intent
import android.os.Bundle
import br.com.silas.carneiro.movieflix.R
import br.com.silas.carneiro.movieflix.ui.base.BaseActivity
import br.com.silas.carneiro.movieflix.ui.home.HomeActivity
import br.com.silas.carneiro.movieflix.ui.register.RegisterActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginContract.View {

    @Inject
    lateinit var presenter : LoginContract.Presenter<LoginContract.View, LoginContract.Interactor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        getActivityComponent().inject(this)
        presenter.onAttach(this)

        btnLogin.setOnClickListener {
            val email = edtEmail?.text.toString()
            val password = edtPassword?.text.toString()
            this.presenter.login(email, password)
        }

        txtRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    override fun goHome() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    override fun emailOrPasswordInvalid() {
        Snackbar.make(coordinatorLayout, getString(R.string.error_user_password), Snackbar.LENGTH_LONG).show()
    }
}
