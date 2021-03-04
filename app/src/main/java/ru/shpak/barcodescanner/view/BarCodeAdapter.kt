package ru.shpak.barcodescanner.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.shpak.barcodescanner.model.BarCode

class BarCodeAdapter(private val listBarCode: List<BarCode>):
    RecyclerView.Adapter<BarCodeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):BarCodeViewHolder =
        BarCodeViewHolder.createViewHolder(parent)

    override fun onBindViewHolder(holder: BarCodeViewHolder, position: Int) {
        val barCode: BarCode  = listBarCode[position]
        holder.barCodeView.text = barCode.barCode
        holder.dateView.text = barCode.date
    }

    override fun getItemCount(): Int {
        return listBarCode.size
    }
}