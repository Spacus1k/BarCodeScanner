package ru.shpak.presentation.di

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import ru.shpak.presentation.MainActivity
import ru.shpak.presentation.ScanActivity
import ru.shpak.presentation.SplashActivity
import ru.shpak.presentation.di.component.MainActivityComponent
import ru.shpak.presentation.di.component.ScanSubComponent
import ru.shpak.presentation.di.component.SplashSubComponent
import ru.shpak.presentation.fragments.*
import ru.shpak.presentation.fragments.di.component.*

@Module(
    subcomponents = [
        MainActivityComponent::class,
        ScanSubComponent::class,
        HistorySubComponent::class,
        MainFragmentSubComponent::class,
        SplashSubComponent::class,
        DialogSubComponent::class,
        SettingsFragmentSubComponent::class,
        ClickedItemFragmentSubComponent::class
    ]
)
interface PresentationModule {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    fun bindsMainActivityFactory(factory: MainActivityComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(SplashActivity::class)
    fun bindsSplashActivityFactory(factory: SplashSubComponent.Factory): AndroidInjector.Factory<*>

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

    @Binds
    @IntoMap
    @ClassKey(ConfirmationDialogFragment::class)
    fun bindsConfirmationDialogFragment(factory: DialogSubComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(SettingsFragment::class)
    fun bindsSettingsFragment(factory: SettingsFragmentSubComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(ClickedBarCodeFragment::class)
    fun bindsClickedItemFragment(factory: ClickedItemFragmentSubComponent.Factory): AndroidInjector.Factory<*>
}