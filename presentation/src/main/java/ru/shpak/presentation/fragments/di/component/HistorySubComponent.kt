package ru.shpak.presentation.fragments.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import ru.shpak.presentation.fragments.HistoryFragment
import ru.shpak.presentation.fragments.di.module.HistoryFragmentModule

@Subcomponent(modules = [HistoryFragmentModule::class])
interface HistorySubComponent : AndroidInjector<HistoryFragment> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<HistoryFragment>
}