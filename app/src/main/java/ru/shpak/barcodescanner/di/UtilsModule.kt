package ru.shpak.barcodescanner.di

import dagger.Module
import dagger.Provides
import ru.shpak.barcodescanner.splash.timer.Timer
import ru.shpak.barcodescanner.splash.timer.TimerImpl

@Module
class UtilsModule {
    @Provides
    fun provideTimer(): Timer = TimerImpl()
}