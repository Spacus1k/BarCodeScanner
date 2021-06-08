package ru.shpak.presentation.di

import dagger.Component
import ru.shpak.presentation.MainViewModel

@Component(modules = [ViewModelModule::class])
interface PresentationSubcomponent {
    fun getViewModel(): MainViewModel
}