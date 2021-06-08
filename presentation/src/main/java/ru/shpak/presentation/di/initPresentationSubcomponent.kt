package ru.shpak.presentation.di

import android.app.Application

class initPresentationSubcomponent: Application() {

    companion object {
        var presentationSubcomponent: PresentationSubcomponent? = null
        fun getComponent() = presentationSubcomponent
    }

    override fun onCreate() {
        super.onCreate()
         presentationSubcomponent = DaggerPresentationSubcomponent.create()
    }
}