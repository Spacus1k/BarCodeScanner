package ru.shpak.barcodescanner.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class BarCode(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @ColumnInfo(name = "barCode") var barCode: String,
    @ColumnInfo(name = "date") val date: String
)
