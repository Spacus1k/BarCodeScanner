package ru.shpak.presentation.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import ru.shpak.presentation.viewModels.MainViewModel
import ru.shpak.presentation.viewModels.SharedPrefViewModel

@Module
interface MainActivityModule {

    @Binds
    fun bindsMainViewModel(mainViewModel: MainViewModel): MainViewModel
    
    @Binds
    fun bindsSharedPrefViewModel(sharedPrefViewModel: SharedPrefViewModel): ViewModel
}