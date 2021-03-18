package ru.shpak.barcodescanner.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.shpak.barcodescanner.model.BarCode

@Database(entities = [BarCode::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun barCodeDao(): BarCodeDao
}
