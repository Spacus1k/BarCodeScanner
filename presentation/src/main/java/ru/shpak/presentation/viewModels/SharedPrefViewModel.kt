package ru.shpak.presentation.viewModels

import android.app.Application
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import ru.shpak.domain.ScanModeInteractor
import ru.shpak.domain.ThemeModeInteractor
import ru.shpak.domain.utils.ScanMode
import ru.shpak.domain.utils.Theme
import javax.inject.Inject

class SharedPrefViewModel @Inject constructor(
    private val themeInteractor: ThemeModeInteractor,
    private val scanModeInteractor: ScanModeInteractor
) :
    ViewModel() {

    fun saveThemeMode(activity: FragmentActivity, theme: Theme) {
        themeInteractor.saveThemeMode(activity, theme)
    }

    fun loadThemeMode(activity: FragmentActivity) {
        themeInteractor.loadThemeMode(activity)
    }

    fun checkThemeMode(activity: FragmentActivity): Theme {
        return themeInteractor.getThemeMode(activity)
    }

    fun setThemeMode(activity: FragmentActivity, theme: Theme) {
        themeInteractor.setThemeMode(activity, theme)
    }

    fun saveScanMode(application: Application, scanMode: ScanMode) {
        scanModeInteractor.saveScanMode(application, scanMode)
    }

    fun getScanMode(application: Application): ScanMode {
        return scanModeInteractor.getScanMode(application)
    }
}