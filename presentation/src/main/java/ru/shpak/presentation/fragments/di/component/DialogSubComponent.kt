package ru.shpak.presentation.fragments.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import ru.shpak.presentation.fragments.ConfirmationDialogFragment
import ru.shpak.presentation.fragments.di.module.DialogFragmentModule

@Subcomponent(modules = [DialogFragmentModule::class])
interface DialogSubComponent: AndroidInjector<ConfirmationDialogFragment> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<ConfirmationDialogFragment>
}