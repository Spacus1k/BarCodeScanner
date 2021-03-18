package ru.shpak.barcodescanner.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.shpak.barcodescanner.R
import ru.shpak.barcodescanner.presentation.view.BarCodeAdapter

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val adapter = BarCodeAdapter()
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.barCodes.observe(this) { barCodes ->
            adapter.updateData(barCodes)
        }

        initBarCodeRecycleView()
        initButton()
    }

    private fun initBarCodeRecycleView() {
        barCodes.layoutManager = LinearLayoutManager(this)
        barCodes.adapter = adapter
    }

    private fun initButton() {
    }

    override fun onClick(view: View?) {
    }
}