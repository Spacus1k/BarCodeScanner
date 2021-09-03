package ru.shpak.presentation.fragments.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import ru.shpak.presentation.fragments.MainFragment

@Subcomponent
interface MainFragmentSubComponent : AndroidInjector<MainFragment>  {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainFragment>
}