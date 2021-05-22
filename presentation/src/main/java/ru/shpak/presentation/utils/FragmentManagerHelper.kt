package ru.shpak.presentation.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun replaceFragment(
    fragmentManager: FragmentManager,
    containerViewId: Int,
    fragment: Fragment,
    isAddToBackStack: Boolean
) {
    with(fragmentManager.beginTransaction()) {
        replace(containerViewId, fragment)

        if (isAddToBackStack){
            addToBackStack(null)
        }
        commit()
    }
}