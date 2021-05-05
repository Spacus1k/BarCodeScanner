package ru.shpak.data.asyncTask

import android.os.AsyncTask
import androidx.room.Room
import ru.shpak.data.App
import ru.shpak.data.AppDatabase

class InitDatabaseAsyncTask : AsyncTask<Unit, Unit, AppDatabase>() {

    override fun doInBackground(vararg params: Unit?): AppDatabase {
//TODO()
        return Room.databaseBuilder(
            App.getApplicationContext(),
            AppDatabase::class.java,
            AppDatabase.NAME_DATABASE
        )
            .build()
//        return Room.databaseBuilder(
//            App.getApplicationContext(),
//            AppDatabase::class.java,
//            AppDatabase.NAME_DATABASE
//        )
//            .fallbackToDestructiveMigration()
//            .build()
    }
}