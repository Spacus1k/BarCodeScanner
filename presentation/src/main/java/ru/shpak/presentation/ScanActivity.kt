package ru.shpak.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView
import ru.shpak.presentation.utils.showDefaultMassage

class ScanActivity : AppCompatActivity(), ZXingScannerView.ResultHandler {

    companion object {
        private const val TEXT_MASSAGE = "Code scanned"
    }

    private val viewModel = MainViewModel()
    private var scannerView: ZXingScannerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scannerView = ZXingScannerView(this)
        setContentView(scannerView)
    }

    override fun onResume() {
        super.onResume()
        scannerView?.let {
            it.setResultHandler(this)
            it.startCamera()
        }
    }

    override fun onPause() {
        super.onPause()
        scannerView?.stopCamera()
    }

    override fun handleResult(scanResult: Result) {
        showDefaultMassage(applicationContext, TEXT_MASSAGE)
        viewModel.addBarCode(scanResult.text)
        onResume()
    }
}