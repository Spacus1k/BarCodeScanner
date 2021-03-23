package ru.shpak.barcodescanner

import android.app.Application
import ru.shpak.barcodescanner.data.AppDatabase
import ru.shpak.barcodescanner.data.asyncTask.InitDatabaseAsyncTask
import ru.shpak.barcodescanner.utils.start

class App : Application() {

    private lateinit var _database: AppDatabase
    val database: AppDatabase get() = _database

    companion object {
        lateinit var instance: App

        fun getApplicationContext(): App {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        _database = InitDatabaseAsyncTask().start()
    }
}