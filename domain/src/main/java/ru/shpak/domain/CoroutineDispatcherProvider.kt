package ru.shpak.domain

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatcherProvider {

    fun getCoroutineDispatcher(): CoroutineDispatcher
}