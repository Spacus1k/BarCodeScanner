package ru.shpak.domain.di

import dagger.Binds
import dagger.Module
import ru.shpak.domain.SharedPrefInteractor
import ru.shpak.domain.SharedPrefInteractorImpl

@Module
interface SharedPrefInteractorModule {

    @Binds
    fun bindSharePrefInteractor(sharePrefInteractorImpl: SharedPrefInteractorImpl): SharedPrefInteractor
}