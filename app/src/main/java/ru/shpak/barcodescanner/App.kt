package ru.shpak.barcodescanner

import android.app.Application
import ru.shpak.barcodescanner.di.AppComponent
import ru.shpak.data.appDatabase
import ru.shpak.data.asyncTask.InitDatabaseAsyncTask
import ru.shpak.presentation.di.DaggerPresentationSubcomponent

class App : Application() {

    companion object {
        private var component: AppComponent? = null
        fun getComponent() = component
    }

    override fun onCreate() {
        super.onCreate()
        initDatabase()
        val presentationComponent = DaggerPresentationSubcomponent.create()

    }

    private fun initDatabase() {
        appDatabase = InitDatabaseAsyncTask(applicationContext).execute().get()
    }
}