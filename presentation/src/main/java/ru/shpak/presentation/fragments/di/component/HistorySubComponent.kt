package ru.shpak.presentation.fragments.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import ru.shpak.presentation.fragments.HistoryFragment
import ru.shpak.presentation.fragments.di.module.HistoryModule

@Subcomponent(modules = [HistoryModule::class])
interface HistorySubComponent : AndroidInjector<HistoryFragment> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<HistoryFragment>
}