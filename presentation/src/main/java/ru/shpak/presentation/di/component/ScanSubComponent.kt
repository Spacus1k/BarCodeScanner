package ru.shpak.presentation.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import ru.shpak.presentation.ScanActivity
import ru.shpak.presentation.di.module.ScanActivityModule
import ru.shpak.presentation.di.module.ViewModelModule

@Subcomponent(modules = [ScanActivityModule::class, ViewModelModule::class])
interface ScanSubComponent : AndroidInjector<ScanActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<ScanActivity>
}