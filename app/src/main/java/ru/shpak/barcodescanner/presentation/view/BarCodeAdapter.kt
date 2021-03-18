package ru.shpak.barcodescanner.presentation.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.shpak.barcodescanner.model.BarCode

class BarCodeAdapter :
    RecyclerView.Adapter<BarCodeViewHolder>() {

    private var list: MutableList<BarCode> = mutableListOf()

    fun updateData(barCodeList: List<BarCode>) {
        list.clear()
<<<<<<< HEAD:app/src/main/java/ru/shpak/barcodescanner/view/BarCodeAdapter.kt
        notifyDataSetChanged()
    }

    fun updateData(barCodeList: Collection<BarCode>){
=======
>>>>>>> 189f547 (added database, ViewModel, Interactor, AsuncTask-functions):app/src/main/java/ru/shpak/barcodescanner/presentation/view/BarCodeAdapter.kt
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