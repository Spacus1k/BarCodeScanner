package ru.shpak.presentation.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import ru.shpak.presentation.SplashActivity
import ru.shpak.presentation.di.module.ViewModelModule

@Subcomponent(modules = [ViewModelModule::class])
interface SplashSubComponent : AndroidInjector<SplashActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<SplashActivity>
}