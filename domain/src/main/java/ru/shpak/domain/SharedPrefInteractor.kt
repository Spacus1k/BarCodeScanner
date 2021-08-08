package ru.shpak.domain

import androidx.fragment.app.FragmentActivity
import ru.shpak.domain.utils.Theme

//TODO add description
interface SharedPrefInteractor{

    fun saveThemeMode(activity: FragmentActivity, theme: Theme)

    fun loadThemeMode(activity: FragmentActivity)

    fun checkThemeMode(activity: FragmentActivity): Theme

    fun setThemeMode(activity: FragmentActivity, theme: Theme)
}