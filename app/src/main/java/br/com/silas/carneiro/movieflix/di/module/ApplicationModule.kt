package br.com.silas.carneiro.movieflix.di.module

import android.app.Application
import android.content.Context
import br.com.silas.carneiro.movieflix.data.config.FirebaseConfig
import br.com.silas.carneiro.movieflix.data.config.FirebaseConfigContract
import br.com.silas.carneiro.movieflix.data.prefs.AppPreferencesHelper
import br.com.silas.carneiro.movieflix.data.prefs.PreferencesHelper
import br.com.silas.carneiro.movieflix.utils.AppConstant
import br.com.silas.carneiro.movieflix.di.ApplicationContext
import br.com.silas.carneiro.movieflix.di.PreferenceInfo
import br.com.silas.carneiro.movieflix.utils.AppConstant.Companion.PREF_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(val application: Application) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context {
        return application
    }

    @Provides
    fun provideApplication(): Application {
        return application
    }

    @Provides
    @PreferenceInfo
    fun providePreferenceName(): String {
        return PREF_NAME
    }

    @Provides
    @Singleton
    fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

    @Provides
    @Singleton
    fun provideFirebaseInstace(): FirebaseConfigContract {
        return FirebaseConfig()
    }
}