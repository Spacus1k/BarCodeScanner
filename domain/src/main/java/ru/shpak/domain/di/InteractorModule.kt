package ru.shpak.domain.di

import dagger.Binds
import dagger.Module
import ru.shpak.domain.BarCodeInteractor
import ru.shpak.domain.BarCodeInteractorImpl

@Module
interface InteractorModule {

    @Binds
    fun bindBarCodeInteractor(barCodeInteractorImpl: BarCodeInteractorImpl) : BarCodeInteractor
}