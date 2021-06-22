package ru.shpak.presentation.di

import dagger.Binds
import dagger.Module
import ru.shpak.presentation.MainViewModel

@Module
interface PresentationModule {
    @Binds
    fun bindsMainViewModel(viewModel: MainViewModel): MainViewModel
}