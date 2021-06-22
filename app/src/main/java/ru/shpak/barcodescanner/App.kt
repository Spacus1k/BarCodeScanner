package ru.shpak.barcodescanner

import android.app.Application
import ru.shpak.barcodescanner.di.DiProvider
import ru.shpak.barcodescanner.di.SubComponents
import ru.shpak.data.appDatabase
import ru.shpak.data.asyncTask.InitDatabaseAsyncTask

class App : Application(), SubComponents {

    override fun onCreate() {
        super.onCreate()
        DiProvider.buildDi(this)
    }

    private fun initDatabase() {
        appDatabase = InitDatabaseAsyncTask(applicationContext).execute().get()
    }
}