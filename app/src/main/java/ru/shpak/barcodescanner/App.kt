package ru.shpak.barcodescanner

import android.app.Application
import ru.shpak.barcodescanner.di.AppComponent
import ru.shpak.barcodescanner.di.DaggerAppComponent
import ru.shpak.data.appDatabase
import ru.shpak.data.asyncTask.InitDatabaseAsyncTask

class App : Application() {

    companion object {
        private var component: AppComponent = DaggerAppComponent.create()
        fun getComponent(): AppComponent = component
    }

    override fun onCreate() {
        super.onCreate()
        initDatabase()
    }

    private fun initDatabase() {
        appDatabase = InitDatabaseAsyncTask(applicationContext).execute().get()
    }
}