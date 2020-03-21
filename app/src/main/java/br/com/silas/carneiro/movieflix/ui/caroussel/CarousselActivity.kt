package br.com.silas.carneiro.movieflix.ui.caroussel

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import br.com.silas.carneiro.movieflix.R
import br.com.silas.carneiro.movieflix.ui.base.BaseCarousselActivity
import br.com.silas.carneiro.movieflix.ui.base.MvpView
import br.com.silas.carneiro.movieflix.ui.login.LoginActivity
import com.github.paolorotolo.appintro.AppIntroFragment
import com.github.paolorotolo.appintro.model.SliderPage
import javax.inject.Inject

class CarousselActivity : BaseCarousselActivity(), CarousselContract.View {

    @Inject
    lateinit var presenter : CarousselContract.Presenter<CarousselContract.View, CarousselContract.Interactor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getActivityComponent().inject(this)
        presenter.onAttach(this)

        var sliderPage = SliderPage()
        sliderPage.title = getString(R.string.introduction)
        sliderPage.description = getString(R.string.read_with_attention)
        //sliderPage.imageDrawable = R.drawable.logo
        sliderPage.bgColor = android.R.color.black
        addSlide(AppIntroFragment.newInstance(sliderPage))


        sliderPage = SliderPage()
        sliderPage.title = getString(R.string.the_best_trailers)
        sliderPage.description = getString(R.string.just_here)
        //sliderPage.imageDrawable = R.drawable.filmes_capa
        sliderPage.bgColor = android.R.color.black
        addSlide(AppIntroFragment.newInstance(sliderPage))

        sliderPage = SliderPage()
        sliderPage.title = getString(R.string.without_wasting_any_more_time)
        sliderPage.description = getString(R.string.come_on)
        //sliderPage.imageDrawable = R.drawable.lets_go
        sliderPage.bgColor = android.R.color.black
        addSlide(AppIntroFragment.newInstance(sliderPage))

        showSkipButton(true)
        isProgressButtonEnabled = true
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        goToLogin()
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        goToLogin()
    }

    private fun goToLogin(){
        setFirstLogin(false)
        startActivity(Intent(this, LoginActivity::class.java))
        onFinish()
    }

    override fun setFirstLogin(isLogged: Boolean) {
        presenter.setFirstLogin(isLogged)
    }
}