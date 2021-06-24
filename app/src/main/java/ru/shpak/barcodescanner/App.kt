package ru.shpak.barcodescanner

import dagger.android.DaggerApplication
import ru.shpak.barcodescanner.di.ApplicationComponent
import ru.shpak.barcodescanner.di.DaggerApplicationComponent
import ru.shpak.data.appDatabase
import ru.shpak.data.asyncTask.InitDatabaseAsyncTask

class App : DaggerApplication(){

    private val appComponent by lazy {
        DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
    }

    override fun applicationInjector(): ApplicationComponent = appComponent


    override fun onCreate() {
        super.onCreate()
        initDatabase()
    }


    private fun initDatabase() {
        appDatabase = InitDatabaseAsyncTask(applicationContext).execute().get()
    }
}