package ru.shpak.domain.di

import dagger.Module

@Module(
    includes = [BarCodeInteractorModule::class, TimerModule::class, SharedPrefInteractorModule::class]
)
interface DomainModule