package ru.shpak.presentation.di.module

import dagger.Binds
import dagger.Module
import ru.shpak.presentation.MainViewModel

@Module
interface MainActivityModule {

    @Binds
    fun bindsMainViewModel(viewModel: MainViewModel): MainViewModel
}