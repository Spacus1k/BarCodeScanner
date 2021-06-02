package ru.shpak.data.asyncTask

import android.annotation.SuppressLint
import android.content.Context
import android.os.AsyncTask
import androidx.room.Room
import ru.shpak.data.AppDatabase

@SuppressLint("StaticFieldLeak")
class InitDatabaseAsyncTask(private val context: Context) : AsyncTask<Unit, Unit, AppDatabase>() {

    override fun doInBackground(vararg params: Unit?): AppDatabase {
// TODO: add migration in database

//        return Room.databaseBuilder(
//           context,
//            AppDatabase::class.java,
//            AppDatabase.NAME_DATABASE
//        )
//            .build()
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.NAME_DATABASE
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}