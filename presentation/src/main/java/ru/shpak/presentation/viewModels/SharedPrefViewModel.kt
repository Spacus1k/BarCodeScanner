package ru.shpak.presentation.viewModels

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import ru.shpak.domain.SharedPrefInteractor
import ru.shpak.domain.SharedPrefInteractorImpl

class SharedPrefViewModel : ViewModel() {

    private val interactor: SharedPrefInteractor = SharedPrefInteractorImpl()

    fun saveThemeMode(activity: FragmentActivity, isDarkModeOn: Boolean) {
        interactor.saveThemeMode(activity, isDarkModeOn)
    }

    fun loadThemeMode(activity: FragmentActivity) {
        interactor.loadThemeMode(activity)
    }

    fun checkDarkMode(activity: FragmentActivity): Boolean = interactor.checkDarkMode(activity)
}