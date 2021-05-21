package ru.shpak.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView
import ru.shpak.presentation.utils.replaceFragment

class ScanFragment : Fragment(R.layout.fragment_scan), ZXingScannerView.ResultHandler {

    private var scannerView: ZXingScannerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scannerView = ZXingScannerView(activity)
        activity?.setContentView(scannerView)
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
        activity?.setContentView(R.layout.activity_main)

        replaceFragment(
            activity?.supportFragmentManager?.beginTransaction(),
            R.id.fragment_container,
            HistoryFragment.newInstance(scanResult.toString())
        )
    }
}