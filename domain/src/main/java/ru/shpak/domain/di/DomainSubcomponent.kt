package ru.shpak.domain.di

import dagger.Component
import ru.shpak.domain.BarCodeInteractor

@Component(modules = [BarCodeInteractorModule::class])
interface DomainSubcomponent {
    fun getBarCodeInteractor():BarCodeInteractor
}