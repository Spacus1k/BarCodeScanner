package ru.shpak.barcodescanner.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.shpak.barcodescanner.splash.SplashActivity
import ru.shpak.barcodescanner.splash.SplashViewModel
import ru.shpak.domain.di.DomainSubcomponent
import ru.shpak.presentation.di.PresentationSubcomponent
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, UtilsModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(target: SplashActivity)
    fun inject(target: SplashViewModel)

    val presentationSubcomponent: PresentationSubcomponent.Factory
    val domainSubcomponent: DomainSubcomponent.Factory
}