package ru.shpak.presentation

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView
import ru.shpak.presentation.utils.showToast
import javax.inject.Inject

class ScanActivity :
    AppCompatActivity(), ZXingScannerView.ResultHandler {

    @Inject
    lateinit var scanViewModel: MainViewModel
    private var scannerView: ZXingScannerView? = null

    private companion object {
        private const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scannerView = ZXingScannerView(this)
        setContentView(scannerView)
    }

    override fun onResume() {
        super.onResume()
        checkPermissions()
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

    private fun checkPermissions() {
        if (isCameraPermissionGranted()) {
            startScanning()
        } else {
            requestCameraPermission()
        }
    }

    private fun isCameraPermissionGranted(): Boolean =
        ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED

    private fun requestCameraPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.CAMERA),
            REQUEST_CODE
        )
    }

    //TODO handle situation when camera permission was turned down
}