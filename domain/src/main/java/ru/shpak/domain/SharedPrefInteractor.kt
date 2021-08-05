package ru.shpak.domain

import androidx.fragment.app.FragmentActivity

//TODO add description
interface SharedPrefInteractor{

    fun saveThemeMode(activity: FragmentActivity, isDarkModeOn: Boolean)

    fun loadThemeMode(activity: FragmentActivity)

    fun checkDarkMode(activity: FragmentActivity): Boolean
}