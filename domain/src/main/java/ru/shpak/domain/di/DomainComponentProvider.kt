package ru.shpak.domain.di

interface DomainComponentProvider {

    fun provideDomainComponent(): DomainSubcomponent
}