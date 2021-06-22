package ru.shpak.barcodescanner.di

import ru.shpak.domain.di.DomainComponentProvider
import ru.shpak.domain.di.DomainSubcomponent
import ru.shpak.presentation.di.PresentationComponentProvider
import ru.shpak.presentation.di.PresentationSubcomponent

interface SubComponents : PresentationComponentProvider, DomainComponentProvider {

    override fun providePresentationComponent(): PresentationSubcomponent {
        return DiProvider.appComponent().presentationSubcomponent.create()
    }

    override fun provideDomainComponent(): DomainSubcomponent {
        return DiProvider.appComponent().domainSubcomponent.create()
    }
}