package ru.shpak.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView
import ru.shpak.domain.utils.ScanMode
import ru.shpak.presentation.base.BaseActivity
import ru.shpak.presentation.utils.*
import ru.shpak.presentation.viewModels.MainViewModel
import ru.shpak.presentation.viewModels.SharedPrefViewModel
import javax.inject.Inject

class ScanActivity : BaseActivity(R.layout.activity_scan), ZXingScannerView.ResultHandler {

    @Inject
    lateinit var scanViewModel: MainViewModel

    @Inject
    lateinit var sharedPrefViewModel: SharedPrefViewModel

    @Inject
    lateinit var permissionManager: PermissionManager

    private var scannerView: ZXingScannerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scannerView = ZXingScannerView(this)
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
            Toast.LENGTH_SHORT
        )
        scanViewModel.addBarCode(scanResult.text)

        when (sharedPrefViewModel.getScanMode(application)) {
            ScanMode.STOP -> startMainActivity()
            ScanMode.NONSTOP -> startScanning()
        }
    }

    private fun startScanning() {
        scannerView?.let {
            it.setResultHandler(this)
            it.startCamera()
        }
    }

    private fun checkPermissions() {
        if (permissionManager.isCameraPermissionGranted(this)) {
            setContentView(scannerView)
            startScanning()
        } else {
            permissionManager.requestCameraPermission(this)
        }
    }

    private fun startMainActivity() {
        startNewActivity(
            applicationContext,
            MainActivity::class.java,
            arrayOf(Intent.FLAG_ACTIVITY_NEW_TASK)
        )
    }
}