package ru.shpak.domain.di

import dagger.Module
import dagger.Provides
import ru.shpak.domain.BarCodeInteractor
import ru.shpak.domain.BarCodeInteractorImpl

@Module
class BarCodeInteractorModule {
    @Provides
    fun provideBarCodeInteractor():BarCodeInteractor = BarCodeInteractorImpl()
}