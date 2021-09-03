package ru.shpak.presentation.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import ru.shpak.presentation.viewModels.MainViewModel
import ru.shpak.presentation.viewModels.SharedPrefViewModel
import ru.shpak.presentation.viewModels.SplashViewModel

@Module
interface ViewModelModule {

    @Binds
    fun bindsSharedPrefViewModel(sharedPrefViewModel: SharedPrefViewModel): ViewModel

    @Binds
    fun bindsMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    fun bindsSplashViewModel(viewModel: SplashViewModel): ViewModel
}