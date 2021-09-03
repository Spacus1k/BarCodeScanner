package ru.shpak.presentation.fragments.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import ru.shpak.presentation.fragments.SettingsFragment

@Subcomponent
interface SettingsFragmentSubComponent : AndroidInjector<SettingsFragment> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<SettingsFragment>
}