package ru.shpak.domain.di

import dagger.Binds
import dagger.Module
import ru.shpak.domain.BarCodeInteractor
import ru.shpak.domain.BarCodeInteractorImpl

@Module
interface DomainModule {
    @Binds
    fun bindsBarCodeInteractor(barCodeInteractorImpl: BarCodeInteractorImpl): BarCodeInteractor
}