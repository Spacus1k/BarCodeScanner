package ru.shpak.barcodescanner.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_history.*
import ru.shpak.barcodescanner.R
import ru.shpak.barcodescanner.model.BarCode
import ru.shpak.barcodescanner.presentation.view.BarCodeAdapter
import ru.shpak.barcodescanner.utils.Constants.KEY_NAME_RESULT_SCAN
import ru.shpak.barcodescanner.utils.getCurrentDate
import ru.shpak.barcodescanner.utils.hideActionBar

class HistoryActivity : AppCompatActivity() {

    private val adapter = BarCodeAdapter()
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        hideActionBar()

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
        with(barCodes){
            layoutManager = LinearLayoutManager(context)
            adapter = this@HistoryActivity.adapter
        }
    }
    
    private fun checkNewCodes() {
        val arguments = intent.extras

        arguments?.let {
            val scanResult = arguments.get(KEY_NAME_RESULT_SCAN).toString()
            viewModel.addBarCode(BarCode(barCode = scanResult, date = getCurrentDate()))
        }
        viewModel.loadBarCodes()
    }
}