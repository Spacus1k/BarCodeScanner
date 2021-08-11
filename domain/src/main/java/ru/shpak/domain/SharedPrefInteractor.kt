package ru.shpak.domain
import androidx.fragment.app.FragmentActivity
import ru.shpak.domain.utils.Theme

/**
 * The Interactor which used shared preferences to save theme mode
 * */
interface SharedPrefInteractor{

    /**
     * The method saves activity theme mode using shared preferences
     * */
    fun saveThemeMode(activity: FragmentActivity, theme: Theme)

    /**
     * The method sets the saved theme in the activity
     * */
    fun loadThemeMode(activity: FragmentActivity)

    /**
     * The method returns the saved theme in the activity
     * */
    fun checkThemeMode(activity: FragmentActivity): Theme

    /**
     * The method sets thе theme to activity
     * */
    fun setThemeMode(activity: FragmentActivity, theme: Theme)
}