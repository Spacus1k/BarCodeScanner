package ru.shpak.presentation.di

import dagger.Subcomponent
import ru.shpak.presentation.MainActivity
import ru.shpak.presentation.ScanActivity
import ru.shpak.presentation.fragments.HistoryFragment
import ru.shpak.presentation.fragments.MainFragment

@Subcomponent(modules = [PresentationModule::class])
interface PresentationSubcomponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): PresentationSubcomponent
    }

    fun inject(target: MainFragment)
    fun inject(target: HistoryFragment)
    fun inject(target: ScanActivity)
}