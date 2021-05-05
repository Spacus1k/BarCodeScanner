package ru.shpak.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ru.shpak.data.model.BarCodeData

@Dao
interface BarCodeDao {
    @Query("SELECT * FROM barcodeData")
    fun getAll(): List<BarCodeData>

    @Insert
    fun insert(barCodeData: BarCodeData)

    @Delete
    fun delete(barCodeData: BarCodeData)
}