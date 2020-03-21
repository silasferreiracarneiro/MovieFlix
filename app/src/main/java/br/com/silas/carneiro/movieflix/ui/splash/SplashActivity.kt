package br.com.silas.carneiro.movieflix.ui.splash

import android.os.Bundle
import android.content.Intent
import android.os.Handler
import br.com.silas.carneiro.movieflix.ui.base.BaseActivity
import br.com.silas.carneiro.movieflix.ui.caroussel.CarousselActivity
import br.com.silas.carneiro.movieflix.ui.home.HomeActivity
import br.com.silas.carneiro.movieflix.ui.login.LoginActivity
import javax.inject.Inject


class SplashActivity : BaseActivity(), SplashContract.View  {

    @Inject
    lateinit var presenter : SplashContract.Presenter<SplashContract.View, SplashContract.Interactor>

    private val SPLASH_TIME_OUT:Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(br.com.silas.carneiro.movieflix.R.layout.activity_splash)

        getActivityComponent().inject(this)
        presenter.onAttach(this)

        Handler().postDelayed({
            presenter.goToActivity()
        }, SPLASH_TIME_OUT)
    }

    override fun goToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    override fun goToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    override fun goToCaroussel() {
        startActivity(Intent(this, CarousselActivity::class.java))
        finish()
    }
}
