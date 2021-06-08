package ru.shpak.presentation.di

import dagger.Module
import dagger.Provides
import ru.shpak.domain.BarCodeInteractor
import ru.shpak.domain.BarCodeInteractorImpl
import ru.shpak.presentation.MainViewModel
import javax.inject.Singleton

@Module
class ViewModelModule {
    @Provides
   fun provideViewModel(interactor:BarCodeInteractorImpl): MainViewModel = MainViewModel(interactor)
}