package ru.shpak.barcodescanner.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.shpak.barcodescanner.R
import ru.shpak.barcodescanner.data.Data
import ru.shpak.barcodescanner.model.BarCode
import ru.shpak.barcodescanner.utils.Util
import ru.shpak.barcodescanner.view.BarCodeAdapter

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBarCodeRecycleView()
        initButton()
    }

    private fun initBarCodeRecycleView() {
        barCodes.layoutManager = LinearLayoutManager(this)
        barCodes.adapter = BarCodeAdapter()
    }

    private fun initButton() {
        buttonSwapLists.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.buttonSwapLists -> Util.swapLists(
                barCodes.adapter as BarCodeAdapter
            )
        }
    }
}