package ru.shpak.presentation.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.shpak.domain.model.BarCode

class BarCodeAdapter :
    RecyclerView.Adapter<BarCodeViewHolder>() {

    private var list: List<BarCode> = mutableListOf()

    fun updateData(listBarCodes: List<BarCode>) {
        list = listBarCodes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarCodeViewHolder =
        BarCodeViewHolder.createViewHolder(parent)

    override fun onBindViewHolder(holder: BarCodeViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}