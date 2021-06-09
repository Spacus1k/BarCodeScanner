package ru.shpak.barcodescanner.di

import dagger.Module
import dagger.Provides
import ru.shpak.barcodescanner.splash.SplashViewModel
import ru.shpak.barcodescanner.splash.timer.Timer

@Module
class ViewModelModule {
    @Provides
    fun provideSplashViewModel(timer: Timer) = SplashViewModel(timer)
}