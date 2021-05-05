package ru.shpak.barcodescanner.presentation

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView
import ru.shpak.barcodescanner.presentation.Constants.KEY_NAME_RESULT_SCAN
import java.util.*

class ScanActivity : Activity(), ZXingScannerView.ResultHandler {

    private var mScannerView: ZXingScannerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mScannerView = ZXingScannerView(this)
        setContentView(mScannerView)
    }

    override fun onResume() {
        super.onResume()
        mScannerView?.setResultHandler(this)
        mScannerView?.startCamera()
    }

    override fun onPause() {
        super.onPause()
        mScannerView?.stopCamera()
    }

    override fun handleResult(scanResult: Result) {
        Log.v(TAG, "$scanResult  ${Date()}")
        Log.v(TAG, scanResult.barcodeFormat.toString())

        val intent = Intent(this, HistoryActivity::class.java)
        intent.putExtra(KEY_NAME_RESULT_SCAN, scanResult.text)
        startActivity(intent)
    }
}