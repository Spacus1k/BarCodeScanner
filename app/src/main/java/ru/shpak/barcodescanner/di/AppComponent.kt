package ru.shpak.barcodescanner.di

import dagger.Component
import ru.shpak.barcodescanner.splash.SplashActivity
import ru.shpak.barcodescanner.splash.SplashViewModel

@Component(modules = [SplashViewModelModule::class, TimerModule::class])
interface AppComponent {

    fun inject(target: SplashActivity)

    fun inject(target: SplashViewModel)
}