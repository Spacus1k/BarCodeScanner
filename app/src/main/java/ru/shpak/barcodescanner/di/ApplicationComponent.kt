package ru.shpak.barcodescanner.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import ru.shpak.domain.di.DomainModule
import ru.shpak.presentation.di.PresentationModule
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class,
        PresentationModule::class,
        DomainModule::class
    ]
)
@Singleton
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}