package br.com.silas.carneiro.movieflix.ui.base

import android.os.Bundle
import android.widget.Toast
import br.com.silas.carneiro.movieflix.App
import br.com.silas.carneiro.movieflix.di.component.ActivityComponent
import br.com.silas.carneiro.movieflix.di.component.DaggerActivityComponent
import br.com.silas.carneiro.movieflix.di.module.DataModule
import br.com.silas.carneiro.movieflix.di.module.InteractorModule
import br.com.silas.carneiro.movieflix.di.module.PresenterModule
import br.com.silas.carneiro.movieflix.utils.NetworkHelper
import com.github.paolorotolo.appintro.AppIntro

abstract class BaseCarousselActivity: AppIntro(), MvpView {

    private lateinit var mActivityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mActivityComponent = DaggerActivityComponent.builder()
            .interactorModule(InteractorModule())
            .presenterModule(PresenterModule())
            .dataModule(DataModule())
            .applicationComponent((application as App).getComponent())
            .build()
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showMessage(resId: Int) {
        showMessage(getString(resId))
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onError(resId: Int) {
        showMessage(getString(resId))
    }

    override fun onError(message: String) {
        showMessage(message)
    }

    override fun alterPermission() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun validatedPermissions() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onGetString(id: Int): String {
        return getString(id)
    }

    override fun onFinish() {
        this.finish()
    }

    override fun isNetworkConnected(): Boolean {
        return NetworkHelper.isNetworkConnected(applicationContext)
    }

    fun getActivityComponent(): ActivityComponent {
        return mActivityComponent
    }
}