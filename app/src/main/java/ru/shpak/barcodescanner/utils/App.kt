package ru.shpak.barcodescanner.utils

import android.app.Application

class App : Application() {


    companion object {
        lateinit var instance: App

        fun getApplicationContext(): App {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}