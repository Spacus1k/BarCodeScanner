package ru.shpak.barcodescanner.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun provideApplicationContext(app: Application): Context = app.applicationContext
}