package ru.shpak.domain.di

import dagger.Module

@Module(
    includes = [InteractorModule::class]
)
interface DomainModule