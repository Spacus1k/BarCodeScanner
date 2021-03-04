package ru.shpak.barcodescanner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.shpak.barcodescanner.model.BarCode
import ru.shpak.barcodescanner.view.BarCodeAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createBarCodeRecycleView(createBareCodeList())

    }

    private fun createBarCodeRecycleView(list: List<BarCode>){
        val linearLayoutManager = LinearLayoutManager(this)
        barCodes.layoutManager = linearLayoutManager

        barCodes.adapter = BarCodeAdapter(createBareCodeList())
    }

    private fun createBareCodeList(): MutableList<BarCode> {

        val list = mutableListOf<BarCode>()
        for( i in (1..30).withIndex()){
            list.add (BarCode("date ${i.index}", "barCode ${i.index}" ))
        }
        return list
    }

}