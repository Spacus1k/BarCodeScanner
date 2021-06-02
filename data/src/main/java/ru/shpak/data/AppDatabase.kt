package ru.shpak.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.shpak.data.AppDatabase.Companion.DATABASE_VERSION
import ru.shpak.data.model.BarCodeData
import ru.shpak.data.utils.DateUtils

@Database(
    entities = [BarCodeData::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
@TypeConverters(DateUtils::class)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val NAME_DATABASE = "barcodeDB"
        const val DATABASE_VERSION = 2
    }

    abstract fun barCodeDao(): BarCodeDao
}