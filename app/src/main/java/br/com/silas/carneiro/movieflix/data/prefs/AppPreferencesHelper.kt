package br.com.silas.carneiro.movieflix.data.prefs

import android.content.Context
import android.content.SharedPreferences
import br.com.silas.carneiro.movieflix.di.ApplicationContext
import br.com.silas.carneiro.movieflix.di.PreferenceInfo
import javax.inject.Inject

class AppPreferencesHelper @Inject constructor(@ApplicationContext context: Context,
                                               @PreferenceInfo prefFileName: String): PreferencesHelper {

    private val mPrefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun getUser() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}