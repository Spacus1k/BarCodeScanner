package ru.shpak.presentation.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import dagger.android.support.DaggerDialogFragment
import ru.shpak.presentation.R
import ru.shpak.presentation.utils.showToast
import ru.shpak.presentation.viewModels.MainViewModel
import javax.inject.Inject

class ConfirmationDialogFragment: DaggerDialogFragment() {

    companion object {
        fun newInstance() = ConfirmationDialogFragment()

        private const val NULL_ACTIVITY_ERROR_MESSAGE = "Activity cannot be null"
    }

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            createDeleteConfirmationDialog(it)
        } ?: throw IllegalStateException(NULL_ACTIVITY_ERROR_MESSAGE)
    }

    private fun createDeleteConfirmationDialog(activity: FragmentActivity): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle(R.string.attention)
            .setMessage(R.string.dialog_question_delete_all)
            .setPositiveButton(R.string.dialog_yes) { _, _ ->
                viewModel.removeAllBarCodes()
                showToast(activity, getString(R.string.delete_successful), Toast.LENGTH_LONG)
            }
            .setNegativeButton(R.string.dialog_cancel) { _, _ ->
                showToast(activity, getString(R.string.delete_canceled), Toast.LENGTH_LONG)
            }
        return builder.create()
    }
}