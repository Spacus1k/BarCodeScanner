package ru.shpak.data

import android.app.Application
import ru.shpak.data.asyncTask.InitDatabaseAsyncTask

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
        _database = InitDatabaseAsyncTask().execute().get()
    }
}