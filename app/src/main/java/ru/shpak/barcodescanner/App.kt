package ru.shpak.barcodescanner

import android.app.Application
import ru.shpak.data.appDatabase
import ru.shpak.data.asyncTask.InitDatabaseAsyncTask

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initDatabase()
    }

    private fun initDatabase() {
        appDatabase = InitDatabaseAsyncTask(applicationContext).execute().get()
    }
}