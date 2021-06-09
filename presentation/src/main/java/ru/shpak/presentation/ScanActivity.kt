package ru.shpak.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView
import ru.shpak.presentation.utils.showToast

class ScanActivity :
    AppCompatActivity(), ZXingScannerView.ResultHandler {

    private val scanViewModel = MainViewModel()
    private var scannerView: ZXingScannerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scannerView = ZXingScannerView(this)
        setContentView(scannerView)
    }

    override fun onResume() {
        super.onResume()
        startScanning()
    }

    override fun onPause() {
        super.onPause()
        scannerView?.stopCamera()
    }

    override fun handleResult(scanResult: Result) {
        showToast(
            applicationContext,
            getString(R.string.message_after_scanning),
            Toast.LENGTH_LONG
        )
        scanViewModel.addBarCode(scanResult.text)
        startScanning()
    }

    private fun startScanning() {
        scannerView?.let {
            it.setResultHandler(this)
            it.startCamera()
        }
    }
}