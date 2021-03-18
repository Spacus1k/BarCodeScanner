package ru.shpak.barcodescanner.model

data class BarCode(
<<<<<<< HEAD
    val date: String,
    var barCode: String
=======
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @ColumnInfo(name = "barCode") var barCode: String,
    @ColumnInfo(name = "date") val date: String
>>>>>>> 189f547 (added database, ViewModel, Interactor, AsuncTask-functions)
)
