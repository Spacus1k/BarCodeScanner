package ru.shpak.barcodescanner

import androidx.room.Room
import dagger.android.DaggerApplication
import kotlinx.coroutines.*
import ru.shpak.barcodescanner.di.ApplicationComponent
import ru.shpak.barcodescanner.di.DaggerApplicationComponent
import ru.shpak.data.AppDatabase
import ru.shpak.data.appDatabase

class App : DaggerApplication() {

    private val appComponent by lazy {
        DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
    }

    override fun applicationInjector(): ApplicationComponent = appComponent

    override fun onCreate() {
        super.onCreate()
        CoroutineScope(Dispatchers.Main).launch {
            initDatabase()
        }
    }

    private fun initDatabase() {
        appDatabase =
            Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                AppDatabase.NAME_DATABASE
            )
                .fallbackToDestructiveMigration()
                .build()
    }
}