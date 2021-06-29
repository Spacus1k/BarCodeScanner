package ru.shpak.presentation.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import ru.shpak.presentation.MainActivity
import ru.shpak.presentation.SplashActivity
import ru.shpak.presentation.di.module.MainActivityModule
import ru.shpak.presentation.di.module.SplashActivityModule

@Subcomponent(modules = [SplashActivityModule::class])
interface SplashSubComponent : AndroidInjector<SplashActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<SplashActivity>
}