package ru.shpak.presentation.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import ru.shpak.presentation.MainActivity
import ru.shpak.presentation.di.module.MainActivityModule


@Subcomponent(modules = [MainActivityModule::class])
interface MainSubComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity>
}