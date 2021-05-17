package ru.shpak.presentation

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView
import ru.shpak.presentation.Constants.KEY_NAME_RESULT_SCAN
import java.util.*

class ScanActivity : AppCompatActivity(), ZXingScannerView.ResultHandler {

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
        Log.v(TAG, "$scanResult  ${Date()}")
        Log.v(TAG, scanResult.barcodeFormat.toString())

        val intent = Intent(this, HistoryActivity::class.java)
        intent.putExtra(KEY_NAME_RESULT_SCAN, scanResult.text)
        startActivity(intent)
    }
}