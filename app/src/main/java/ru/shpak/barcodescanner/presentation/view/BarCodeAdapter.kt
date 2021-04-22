package ru.shpak.barcodescanner.presentation.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.shpak.barcodescanner.model.BarCode
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class BarCodeAdapter :
    RecyclerView.Adapter<BarCodeViewHolder>() {

    private var list: List<BarCode> = mutableListOf()

    fun updateData(barCodeList: List<BarCode>) {
        list = barCodeList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarCodeViewHolder =
        BarCodeViewHolder.createViewHolder(parent)

    override fun onBindViewHolder(holder: BarCodeViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}