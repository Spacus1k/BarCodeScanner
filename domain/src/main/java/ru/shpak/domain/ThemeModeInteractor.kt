package ru.shpak.domain

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import ru.shpak.domain.utils.Theme

/**
 * The Interactor that saves theme mode
 * */
interface ThemeModeInteractor {

    /**
     * The method saves activity theme mode
     * */
    fun saveThemeMode(activity: Activity, theme: Theme)

    /**
     * The method sets the saved theme in the activity
     * */
    fun loadThemeMode(activity: Activity)

    /**
     * The method returns the saved theme in the activity
     * */
    fun getThemeMode(activity: Activity): Theme

    /**
     * The method sets thе theme to activity
     * */
    fun setThemeMode(activity: Activity, theme: Theme)
}