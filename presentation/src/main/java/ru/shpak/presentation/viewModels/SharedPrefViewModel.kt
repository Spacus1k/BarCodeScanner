package ru.shpak.presentation.viewModels

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import ru.shpak.domain.SharedPrefInteractor
import ru.shpak.domain.utils.Theme
import javax.inject.Inject

class SharedPrefViewModel @Inject constructor(private val interactor: SharedPrefInteractor) :
    ViewModel() {

    fun saveThemeMode(activity: FragmentActivity, theme: Theme) {
        interactor.saveThemeMode(activity, theme)
    }

    fun loadThemeMode(activity: FragmentActivity) {
        interactor.loadThemeMode(activity)
    }

    fun checkThemeMode(activity: FragmentActivity): Theme = interactor.checkThemeMode(activity)

    fun setThemeMode(activity: FragmentActivity, theme: Theme) {
        interactor.setThemeMode(activity, theme)
    }
}