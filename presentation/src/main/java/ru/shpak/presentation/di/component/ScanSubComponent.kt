package ru.shpak.presentation.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import ru.shpak.presentation.ScanActivity
import ru.shpak.presentation.di.module.ScanActivityModule

@Subcomponent(modules = [ScanActivityModule::class])
interface ScanSubComponent : AndroidInjector<ScanActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<ScanActivity>
}