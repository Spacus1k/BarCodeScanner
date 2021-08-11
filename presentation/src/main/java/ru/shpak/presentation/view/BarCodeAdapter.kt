package ru.shpak.presentation.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.shpak.domain.model.BarCode

class BarCodeAdapter(
    private val itemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<BarCodeViewHolder>() {

    private var list: List<BarCode> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarCodeViewHolder =
        BarCodeViewHolder.createViewHolder(parent, itemClickListener)

    override fun onBindViewHolder(holder: BarCodeViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun updateData(listBarCodes: List<BarCode>) {
        list = listBarCodes
        notifyDataSetChanged()
    }

    fun getItem(position: Int):BarCode{
        return list[position]
    }

    interface OnItemClickListener {

        fun onItemClick(position: Int)
    }
}