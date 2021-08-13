package ru.shpak.domain.di

import dagger.Binds
import dagger.Module
import ru.shpak.domain.*

@Module
interface InteractorModule {

    @Binds
    fun bindBarCodeInteractor(barCodeInteractorImpl: BarCodeInteractorImpl): BarCodeInteractor

    @Binds
    fun bindScanModeInteractor(scanModeInteractorImpl: ScanModeInteractorImpl): ScanModeInteractor

    @Binds
    fun bindThemeModeInteractor(ThemeModeInteractorImpl: ThemeModeInteractorImpl): ThemeModeInteractor
}