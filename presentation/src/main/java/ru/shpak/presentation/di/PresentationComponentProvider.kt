package ru.shpak.presentation.di

interface PresentationComponentProvider {

    fun providePresentationComponent(): PresentationSubcomponent
}