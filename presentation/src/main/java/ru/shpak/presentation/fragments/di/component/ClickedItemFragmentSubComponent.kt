package ru.shpak.presentation.fragments.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import ru.shpak.presentation.fragments.ClickedItemFragment
import ru.shpak.presentation.fragments.di.module.ClickedItemFragmentModule

@Subcomponent(modules = [ClickedItemFragmentModule::class])
interface ClickedItemFragmentSubComponent : AndroidInjector<ClickedItemFragment>{

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<ClickedItemFragment>
}