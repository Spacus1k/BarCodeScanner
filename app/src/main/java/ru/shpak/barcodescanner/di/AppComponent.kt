package ru.shpak.barcodescanner.di

import dagger.Component
import ru.shpak.domain.BarCodeInteractorImpl
import ru.shpak.domain.di.BarCodeInteractorModule
import ru.shpak.presentation.di.ViewModelModule

@Component(modules = [BarCodeInteractorModule::class, ViewModelModule::class])
interface AppComponent {
    fun getBarCodeInteractor(): BarCodeInteractorImpl
}