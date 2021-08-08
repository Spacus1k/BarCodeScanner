package ru.shpak.presentation.fragments.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import ru.shpak.presentation.fragments.SettingsFragment
import ru.shpak.presentation.fragments.di.module.SettingsFragmentModule

@Subcomponent(modules = [SettingsFragmentModule::class])
interface SettingsFragmentSubComponent : AndroidInjector<SettingsFragment> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<SettingsFragment>
}