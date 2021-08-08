package ru.shpak.presentation.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import ru.shpak.presentation.viewModels.SharedPrefViewModel
import ru.shpak.presentation.viewModels.SplashViewModel

@Module
interface SplashActivityModule {

    @Binds
    fun bindsSplashViewModel(viewModel: SplashViewModel): ViewModel
}