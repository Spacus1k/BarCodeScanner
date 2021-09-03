package ru.shpak.presentation.di.module

import dagger.Binds
import dagger.Module
import ru.shpak.presentation.utils.PermissionManager
import ru.shpak.presentation.utils.PermissionManagerImpl

@Module
interface ScanActivityModule {

    @Binds
    fun bindsPermissionManager(permissionManagerImpl: PermissionManagerImpl): PermissionManager
}