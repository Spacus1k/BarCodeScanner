package ru.shpak.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_cliecked_item.*
import kotlinx.android.synthetic.main.fragment_cliecked_item.toolbar
import kotlinx.android.synthetic.main.fragment_main.*
import ru.shpak.domain.BarCodeInteractorImpl
import ru.shpak.domain.model.BarCode
import ru.shpak.domain.utils.dateToString
import ru.shpak.presentation.R
import ru.shpak.presentation.utils.addFragment
import ru.shpak.presentation.utils.showToast
import ru.shpak.presentation.viewModels.MainViewModel
import javax.inject.Inject

class ClickedItemFragment : DaggerFragment(R.layout.fragment_cliecked_item) {

    companion object {
        fun newInstance() = ClickedItemFragment()
        const val KEY = "clicked_item"
    }

    @Inject
    lateinit var viewModel: MainViewModel
    private var barCode: BarCode? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBarCode()
        initButtons()
    }

    private fun initBarCode() {
        val bundle = arguments
        if (bundle != null) {
            barCode = bundle.getParcelable(KEY)
        }
        barCode?.let {
            scan_result.text = it.barCode
            date.text = dateToString(it.date)
        }
    }

    private fun initButtons() {
        toolbar.setOnClickListener {
            activity?.onBackPressed()
        }

        button_delete_item.setOnClickListener {
            barCode?.let { barCode ->
                viewModel.removeBarCode(barCode.id)
            }
            activity?.let {
                showToast(it, "Delete successfully")
                openMainFragment()
                viewModel.loadBarCodes()
                it.onBackPressed()
            }
        }
    }

    private fun openMainFragment() {
        activity?.supportFragmentManager?.let {
            addFragment(
                it, R.id.activity_fragment_container,
                MainFragment.newInstance(),
                false
            )
        }
    }
}