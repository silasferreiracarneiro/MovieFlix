package br.com.silas.carneiro.movieflix.ui.base

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.FrameLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import br.com.silas.carneiro.movieflix.R
import br.com.silas.carneiro.movieflix.di.component.ActivityComponent
import br.com.silas.carneiro.movieflix.utils.DialogHelper
import br.com.silas.carneiro.movieflix.utils.NetworkHelper
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheetDialogFragment : BottomSheetDialogFragment(), MvpView {

    private var mActivity: BaseActivity? = null
    private var mProgressDialog: ProgressDialog? = null

    private val awards = arrayListOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA, Manifest.permission.INTERNET)

    private val REQUEST_PERMISSION = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(view)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnShowListener { dialogInterface ->
            val bottomSheetDialog = dialogInterface as BottomSheetDialog
            setupFullHeight(bottomSheetDialog)
        }
        return dialog
    }

    private fun setupFullHeight(bottomSheetDialog: BottomSheetDialog) {
        val bottomSheet = bottomSheetDialog.findViewById<View>(R.id.design_bottom_sheet) as FrameLayout?
        val behavior: BottomSheetBehavior<*> = BottomSheetBehavior.from(bottomSheet)
        val layoutParams = bottomSheet!!.layoutParams
        val windowHeight = getWindowHeight()
        if (layoutParams != null) {
            layoutParams.height = windowHeight
        }
        bottomSheet.layoutParams = layoutParams
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    private fun getWindowHeight(): Int {
        val displayMetrics = DisplayMetrics()
        (context as Activity?)!!.windowManager.defaultDisplay
            .getMetrics(displayMetrics)
        return displayMetrics.heightPixels
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            super.onAttach(context)
            this.mActivity = context
        }
    }

    override fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog?.isShowing!!) {
            mProgressDialog?.cancel()
        }
    }

    override fun showLoading() {
        hideLoading()
        mProgressDialog = DialogHelper().showLoadingDialog(context!!)
    }

    override fun isNetworkConnected(): Boolean {
        return NetworkHelper.isNetworkConnected(context!!)
    }

    override fun onDetach() {
        mActivity = null
        super.onDetach()
    }

    override fun showMessage(resId: Int) {
        if(mActivity != null){
            mActivity?.showMessage(resId)
        }
    }

    override fun showMessage(message: String) {
        if (mActivity != null) {
            mActivity?.showMessage(message)
        }
    }

    override fun onError(resId: Int) {
        if(mActivity != null){
            mActivity?.onError(resId)
        }
    }

    override fun onError(message: String) {
        if(mActivity != null){
            mActivity?.onError(message)
        }
    }

    override fun onFinish() {
        if(mActivity != null){
            mActivity?.onFinish()
        }
    }

    fun getActivityComponent(): ActivityComponent? {
        return if (mActivity != null) {
            mActivity?.getActivityComponent()
        } else null
    }

    fun getBaseActivity(): BaseActivity {
        return mActivity!!
    }

    fun onFragmentAttached() {

    }

    fun onFragmentDetached(tag: String) {

    }

    protected abstract fun setUp(view: View)

    interface Callback {

        fun onFragmentAttached()

        fun onFragmentDetached(tag: String)
    }

    override fun onGetString(id: Int): String {
        return getString(id)
    }

    override fun validatedPermissions() {
        var arrayRequest = arrayListOf<String>()

        awards.forEach{
            if(ContextCompat.checkSelfPermission(context!!, it) != PackageManager.PERMISSION_GRANTED){
                arrayRequest.add(it)
            }
        }

        if(arrayRequest.size > 0){
            val array = arrayOfNulls<String>(arrayRequest.size)
            ActivityCompat.requestPermissions(activity!!, arrayRequest.toArray(array), REQUEST_PERMISSION)
        }
    }

    override fun alterPermission() {
        var builder = AlertDialog.Builder(context!!)
        builder.setTitle("Permissões negadas")
        builder.setMessage("Para utilizar o app é necessário aceitar as permissões")
        builder.setCancelable(false)
        builder.setPositiveButton("Confirmar"){ dialog, which ->
            onFinish()
        }
        builder.create().show()
    }
 }