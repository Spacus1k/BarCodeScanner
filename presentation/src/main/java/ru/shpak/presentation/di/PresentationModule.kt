package ru.shpak.presentation.di

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import ru.shpak.presentation.MainActivity
import ru.shpak.presentation.ScanActivity
import ru.shpak.presentation.di.component.MainSubComponent
import ru.shpak.presentation.di.component.ScanSubComponent
import ru.shpak.presentation.fragments.HistoryFragment
import ru.shpak.presentation.fragments.MainFragment
import ru.shpak.presentation.fragments.di.component.HistorySubComponent
import ru.shpak.presentation.fragments.di.component.MainFragmentSubComponent

@Module(
    subcomponents = [
        MainSubComponent::class,
        ScanSubComponent::class,
        HistorySubComponent::class,
        MainFragmentSubComponent::class
    ]
)
interface PresentationModule {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    fun bindsMainActivityFactory(factory: MainSubComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(ScanActivity::class)
    fun bindsScanActivityFactory(factory: ScanSubComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(HistoryFragment::class)
    fun bindsHistoryFragment(factory: HistorySubComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(MainFragment::class)
    fun bindsMainFragment(factory: MainFragmentSubComponent.Factory): AndroidInjector.Factory<*>
}