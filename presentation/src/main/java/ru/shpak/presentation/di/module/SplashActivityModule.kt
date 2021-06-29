package ru.shpak.presentation.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import ru.shpak.presentation.SplashViewModel

@Module
interface SplashActivityModule {

    @Binds
    fun bindsSplashViewModel(viewModel: SplashViewModel): ViewModel
}