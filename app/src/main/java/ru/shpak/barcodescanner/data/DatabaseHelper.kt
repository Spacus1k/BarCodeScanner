package ru.shpak.barcodescanner.data

import android.os.AsyncTask
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import ru.shpak.barcodescanner.model.BarCode
import ru.shpak.barcodescanner.utils.App
import ru.shpak.barcodescanner.utils.Util
import ru.shpak.barcodescanner.view.BarCodeAdapter


class DatabaseHelper() : AsyncTask<Unit, Unit, AppDatabase>() {

    override fun doInBackground(vararg params: Unit?): AppDatabase {
        val database = Room.databaseBuilder(
            App.getApplicationContext(),
            AppDatabase::class.java,
            "database"
        )
            .build()
        val barCodeDao = database.barCodeDao()
        barCodeDao.insert(BarCode(1, "some code", "date"))

        return database
    }

}