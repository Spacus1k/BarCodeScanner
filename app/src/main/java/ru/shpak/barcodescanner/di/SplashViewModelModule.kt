package ru.shpak.barcodescanner.di

import dagger.Module
import dagger.Provides
import ru.shpak.barcodescanner.splash.SplashViewModel

@Module
class SplashViewModelModule {
    @Provides
    fun provideSplashViewModel() = SplashViewModel()
}