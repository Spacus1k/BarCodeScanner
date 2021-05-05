package ru.shpak.barcodescanner.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.shpak.barcodescanner.R
import ru.shpak.barcodescanner.presentation.utils.startNewActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initButtons()
    }

    private fun initButtons() {
        scanButton.setOnClickListener(this)
        historyButton.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        view?.let {
            when (view.id) {
                R.id.historyButton -> startNewActivity(this, HistoryActivity::class.java)
                R.id.scanButton -> startNewActivity(this, ScanActivity::class.java)
            }
        }
    }
}