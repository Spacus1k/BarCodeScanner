package ru.shpak.presentation.fragments.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import ru.shpak.presentation.fragments.ClickedBarCodeFragment

@Subcomponent
interface ClickedItemFragmentSubComponent : AndroidInjector<ClickedBarCodeFragment>{

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<ClickedBarCodeFragment>
}