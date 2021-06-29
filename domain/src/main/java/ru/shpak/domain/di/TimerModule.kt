package ru.shpak.domain.di

import dagger.Binds
import dagger.Module
import ru.shpak.domain.BarCodeInteractor
import ru.shpak.domain.BarCodeInteractorImpl
import ru.shpak.domain.Timer
import ru.shpak.domain.TimerImpl

@Module
interface TimerModule {

    @Binds
    fun bindsTimer(timerImpl: TimerImpl): Timer
}