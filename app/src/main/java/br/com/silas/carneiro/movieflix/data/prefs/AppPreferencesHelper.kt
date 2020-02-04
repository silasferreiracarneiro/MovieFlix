package br.com.silas.carneiro.movieflix.data.prefs

import android.content.Context
import android.content.SharedPreferences
import br.com.silas.carneiro.movieflix.di.ApplicationContext
import br.com.silas.carneiro.movieflix.di.PreferenceInfo
import br.com.silas.carneiro.movieflix.domain.User
import br.com.silas.carneiro.movieflix.utils.AppConstant.Companion.FIRST_LOGIN
import br.com.silas.carneiro.movieflix.utils.AppConstant.Companion.USER
import com.google.firebase.auth.FirebaseUser
import com.google.gson.Gson
import java.lang.Exception
import javax.inject.Inject

class AppPreferencesHelper @Inject constructor(@ApplicationContext context: Context,
                                               @PreferenceInfo prefFileName: String): PreferencesHelper {

    private val mPrefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun getUser() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun savedUser(user: User, onSucess: () -> Unit, onError: () -> Unit) {
        try {
            mPrefs.edit().putString(USER, Gson().toJson(user)).apply()
            onSucess()
        }catch (e: Exception){
            e.printStackTrace()
            onError()
        }
    }

    override fun getFirstLogin(): Boolean {
        return mPrefs.run { getBoolean(FIRST_LOGIN, false) }
    }

    override fun setFirstLogin(firstLogin: Boolean) {
        mPrefs.edit().putBoolean(FIRST_LOGIN, firstLogin).apply()
    }
}