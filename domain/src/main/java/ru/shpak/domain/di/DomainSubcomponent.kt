package ru.shpak.domain.di

import dagger.Subcomponent

@Subcomponent(modules = [DomainModule::class])

interface DomainSubcomponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): DomainSubcomponent
    }
}