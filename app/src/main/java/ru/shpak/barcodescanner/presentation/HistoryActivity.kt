package ru.shpak.barcodescanner.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_history.*
import ru.shpak.barcodescanner.R
import ru.shpak.barcodescanner.model.BarCode
import ru.shpak.barcodescanner.presentation.view.BarCodeAdapter
import ru.shpak.barcodescanner.utils.getCurrentDate

class HistoryActivity : AppCompatActivity() {

    private val adapter = BarCodeAdapter()
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        this.supportActionBar?.hide()

        initObservers()
        initBarCodeRecycleView()
        checkNewCodes()
    }

    private fun initObservers() {
        viewModel.barCodes.observe(this) { barCodes ->
            adapter.updateData(barCodes)
        }
    }

    private fun initBarCodeRecycleView() {
        barCodes.layoutManager = LinearLayoutManager(this)
        barCodes.adapter = adapter
    }

    private fun checkNewCodes() {
        val arguments = intent.extras

        arguments?.let {
            val scanResult = arguments.get("scanResult").toString()
            viewModel.addBarCode(BarCode(barCode = scanResult, date = getCurrentDate()))
        }
        viewModel.loadBarCodes()
    }
}