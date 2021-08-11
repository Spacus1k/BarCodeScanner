package ru.shpak.domain

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.FragmentActivity
import ru.shpak.domain.utils.Theme
import javax.inject.Inject

class SharedPrefInteractorImpl @Inject constructor() : SharedPrefInteractor {

    companion object{
        const val SHARED_PREF_NAME = "sharedPrefs"
        const val EXCEPTION_MESSAGE = "Theme cannot be null"
        const val KEY = "ThemeMode"
    }
    override fun saveThemeMode(activity: FragmentActivity, theme: Theme) {
        val sharedPreferences = activity.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.putInt(KEY, theme.mode)
        editor?.apply()
    }

    override fun loadThemeMode(activity: FragmentActivity) {
        val theme  = checkThemeMode(activity)
        setThemeMode(activity, theme)
    }

    override fun checkThemeMode(activity: FragmentActivity): Theme {
        val mode = activity.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            .getInt(KEY, Theme.LIGHT.mode)
        return when (mode) {
            Theme.LIGHT.mode -> Theme.LIGHT
            Theme.DARK.mode -> Theme.DARK
            else -> throw throw IllegalStateException(EXCEPTION_MESSAGE)
        }
    }

    override fun setThemeMode(activity: FragmentActivity, theme: Theme) {
        when (theme) {
            Theme.DARK -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            Theme.LIGHT -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        saveThemeMode(activity, theme)
    }
}