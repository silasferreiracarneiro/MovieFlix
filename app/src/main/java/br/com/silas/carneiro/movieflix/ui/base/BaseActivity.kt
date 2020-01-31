package br.com.silas.carneiro.movieflix.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.silas.carneiro.movieflix.App
import br.com.silas.carneiro.movieflix.di.component.ActivityComponent
import br.com.silas.carneiro.movieflix.di.component.DaggerActivityComponent
import br.com.silas.carneiro.movieflix.di.module.DataModule
import br.com.silas.carneiro.movieflix.di.module.InteractorModule
import br.com.silas.carneiro.movieflix.di.module.PresenterModule
import br.com.silas.carneiro.movieflix.utils.DialogHelper
import br.com.silas.carneiro.movieflix.utils.NetworkHelper

abstract class BaseActivity: AppCompatActivity(), MvpView {

    private var mProgressDialog: ProgressDialog? = null
    private lateinit var mActivityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mActivityComponent = DaggerActivityComponent.builder()
            .interactorModule(InteractorModule(this))
            .presenterModule(PresenterModule(this))
            .dataModule(DataModule(this))
            .applicationComponent((application as App).getComponent())
            .build()
    }

    override fun showLoading() {
        hideLoading()
        mProgressDialog = DialogHelper().showLoadingDialog(applicationContext)
    }

    override fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog?.isShowing!!) {
            mProgressDialog?.cancel()
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(id: Int) {
        showMessage(getString(id))
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