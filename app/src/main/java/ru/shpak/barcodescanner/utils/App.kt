package ru.shpak.barcodescanner.utils

import android.app.Application
import ru.shpak.barcodescanner.data.AppDatabase
import ru.shpak.barcodescanner.data.DatabaseHelper

class App : Application() {

    private lateinit var database: AppDatabase

    companion object {
        lateinit var instance: App

        fun getApplicationContext(): App {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
       database =  DatabaseHelper().execute().get()
    }

    fun getDatabase(): AppDatabase {
        return database
    }
}