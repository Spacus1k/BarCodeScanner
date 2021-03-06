package ru.shpak.barcodescanner.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.shpak.barcodescanner.model.BarCode

class BarCodeAdapter :
    RecyclerView.Adapter<BarCodeViewHolder>() {

    private var list: MutableList<BarCode> = mutableListOf()

    fun clear() {
        list.clear()
        notifyDataSetChanged()
    }

    fun updateData(barCodeList: Collection<BarCode>){
        list.addAll(barCodeList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarCodeViewHolder =
        BarCodeViewHolder.createViewHolder(parent)

    override fun onBindViewHolder(holder: BarCodeViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}