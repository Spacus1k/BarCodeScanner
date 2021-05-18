package ru.shpak.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_history.*
import ru.shpak.presentation.Constants.KEY_NAME_RESULT_SCAN
import ru.shpak.presentation.view.BarCodeAdapter
import java.util.*

class HistoryActivity : AppCompatActivity() {

    private val adapter = BarCodeAdapter()
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

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
        with(barCodes) {
            layoutManager = LinearLayoutManager(context)
            adapter = this@HistoryActivity.adapter
        }
    }

    private fun checkNewCodes() {
        val arguments = intent.extras

        arguments?.let {
            val scanResult = arguments.get(KEY_NAME_RESULT_SCAN).toString()
            viewModel.addBarCode(scanResult)
        }
        viewModel.loadBarCodes()
    }
}