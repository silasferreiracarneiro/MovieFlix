package br.com.silas.carneiro.movieflix.di.component

import br.com.silas.carneiro.movieflix.di.PerActivity
import br.com.silas.carneiro.movieflix.di.module.DataModule
import br.com.silas.carneiro.movieflix.di.module.InteractorModule
import br.com.silas.carneiro.movieflix.di.module.PresenterModule
import br.com.silas.carneiro.movieflix.ui.login.LoginActivity
import br.com.silas.carneiro.movieflix.ui.register.RegisterActivity
import dagger.Component

@PerActivity
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [
        PresenterModule::class,
        InteractorModule::class,
        DataModule::class
    ])
interface ActivityComponent {

    fun inject(activity: LoginActivity)
    //fun inject(activity: HomeActivity)
    fun inject(activity: RegisterActivity)

}