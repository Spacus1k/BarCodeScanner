package ru.shpak.domain

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.FragmentActivity

class SharedPrefInteractorImpl : SharedPrefInteractor {

    override fun saveThemeMode(activity: FragmentActivity, isDarkModeOn: Boolean) {
        val sharedPreferences = activity.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.putBoolean("Theme_mode", isDarkModeOn)
        editor?.apply()
    }

    override fun loadThemeMode(activity: FragmentActivity) {
        val sharedPreferences = activity.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        when (sharedPreferences.getBoolean("Theme_mode", false)) {
            true -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            false -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    override fun checkDarkMode(activity: FragmentActivity): Boolean {
        return activity.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            .getBoolean("Theme_mode", false)
    }
}