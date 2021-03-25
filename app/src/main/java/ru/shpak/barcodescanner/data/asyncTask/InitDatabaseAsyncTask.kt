package ru.shpak.barcodescanner.data.asyncTask

import android.os.AsyncTask
import androidx.room.Room
import ru.shpak.barcodescanner.App
import ru.shpak.barcodescanner.data.AppDatabase

class InitDatabaseAsyncTask : AsyncTask<Unit, Unit, AppDatabase>() {

    override fun doInBackground(vararg params: Unit?): AppDatabase {

        return Room.databaseBuilder(
            App.getApplicationContext(),
            AppDatabase::class.java,
           AppDatabase.NAME_DATABASE
        )
            .build()
    }
}