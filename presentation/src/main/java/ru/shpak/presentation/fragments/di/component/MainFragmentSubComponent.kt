package ru.shpak.presentation.fragments.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import ru.shpak.presentation.fragments.MainFragment
import ru.shpak.presentation.fragments.di.module.MainFragmentModule

@Subcomponent(modules = [MainFragmentModule::class])
interface MainFragmentSubComponent : AndroidInjector<MainFragment>  {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainFragment>
}