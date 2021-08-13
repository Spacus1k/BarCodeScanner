package ru.shpak.domain

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.FragmentActivity
import ru.shpak.domain.utils.Theme
import javax.inject.Inject

class ThemeModeInteractorImpl @Inject constructor() : ThemeModeInteractor {

    companion object {
        private const val SHARED_PREF_NAME = "ThemeSharedPrefs"
        private const val NULL_THEME_EXCEPTION_MESSAGE = "Theme cannot be null"
        private const val KEY = "ThemeMode"
    }

    override fun saveThemeMode(activity: Activity, theme: Theme) {
        val sharedPreferences =
            activity.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.putInt(KEY, theme.mode)
        editor?.apply()
    }

    override fun loadThemeMode(activity: Activity) {
        val theme = getThemeMode(activity)
        setThemeMode(activity, theme)
    }

    override fun getThemeMode(activity: Activity): Theme {
        val mode = activity.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            .getInt(KEY, Theme.LIGHT.mode)
        return when (mode) {
            Theme.LIGHT.mode -> Theme.LIGHT
            Theme.DARK.mode -> Theme.DARK
            else -> throw IllegalStateException(NULL_THEME_EXCEPTION_MESSAGE)
        }
    }

    override fun setThemeMode(activity: Activity, theme: Theme) {
        AppCompatDelegate.setDefaultNightMode(
            when (theme) {
                Theme.DARK -> AppCompatDelegate.MODE_NIGHT_YES
                Theme.LIGHT -> AppCompatDelegate.MODE_NIGHT_NO
            }
        )
        saveThemeMode(activity, theme)
    }
}