package ru.shpak.presentation.fragments.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import ru.shpak.presentation.fragments.HistoryFragment

@Subcomponent
interface HistorySubComponent : AndroidInjector<HistoryFragment> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<HistoryFragment>
}