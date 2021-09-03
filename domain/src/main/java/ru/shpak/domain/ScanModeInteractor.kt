package ru.shpak.domain

import android.app.Application
import ru.shpak.domain.utils.ScanMode

/**
 * The Interactor that saves scanning mode
 * */
interface ScanModeInteractor {

    /**
     * The method saves scanning mode
     * */
    fun saveScanMode(application: Application, scanMode: ScanMode)

    /**
     * The method returns the saved scanning mode in the activity
     * @return true - continuous scanning mode
     * @return false - discontinuous scanning mode
     * */
    fun getScanMode(application: Application): ScanMode
}