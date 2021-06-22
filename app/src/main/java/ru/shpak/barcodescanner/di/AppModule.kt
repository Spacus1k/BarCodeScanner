package ru.shpak.barcodescanner.di

import dagger.Module
import ru.shpak.domain.di.DomainSubcomponent
import ru.shpak.presentation.di.PresentationSubcomponent

@Module(
    subcomponents = [
        PresentationSubcomponent::class,
        DomainSubcomponent::class
    ]
)
class AppModule