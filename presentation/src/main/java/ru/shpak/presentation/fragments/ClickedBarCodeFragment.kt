package ru.shpak.presentation.fragments

import android.app.SearchManager
import android.content.*
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentActivity
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_cliecked_item.*
import ru.shpak.domain.model.BarCode
import ru.shpak.domain.utils.dateToString
import ru.shpak.presentation.R
import ru.shpak.presentation.utils.*
import ru.shpak.presentation.viewModels.MainViewModel
import javax.inject.Inject

class ClickedBarCodeFragment(private val barCode: BarCode) :
    DaggerFragment(R.layout.fragment_cliecked_item) {

    companion object {
        fun newInstance(barCode: BarCode) = ClickedBarCodeFragment(barCode)

        private const val TYPE = "text/plain"
        private const val LABEL = "text"
    }

    @Inject
    lateinit var viewModel: MainViewModel
    private var router: Router? = null

    private val menuClickListener = Toolbar.OnMenuItemClickListener { item ->
        activity?.let {
            when (item?.itemId) {
                R.id.action_delete -> deleteItem(barCode)
                R.id.action_copy -> copyText(barCode)
                R.id.action_share -> sendMessage(barCode.barCode)
            }
        }
        true
    }

    private val clickListener = View.OnClickListener {
        when (it?.id) {
            R.id.toolbar -> activity?.onBackPressed()
            R.id.search_button -> searchNet(barCode)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTextView()
        initButtons()
        router = activity?.let { Router(it, R.id.activity_fragment_container) }
    }

    private fun initTextView() {
        scan_result.text = barCode.barCode
        date.text = dateToString(barCode.date)
    }

    private fun initButtons() {
        toolbar.setOnClickListener(clickListener)
        search_button.setOnClickListener(clickListener)
        toolbar.setOnMenuItemClickListener(menuClickListener)
    }

    private fun deleteItem(barCode: BarCode) {
        viewModel.removeBarCodeById(barCode.id)

        activity?.let {
            activity
            showToast(it, it.getString(R.string.delete_successfully))
            it.onBackPressed()
        }

        router?.openFragment(
            MainFragment.newInstance(),
            isAddToBackStack = false
        )
    }

    private fun copyText(barCode: BarCode) {
        val clipboardManager =
            activity?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText(LABEL, barCode.barCode)
        clipboardManager.setPrimaryClip(clipData)

        activity?.let { showToast(it, it.getString(R.string.copied_to_clipboard)) }
    }

    private fun sendMessage(message: String) {
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, message)
            type = TYPE
        }
        activity?.startActivity(intent)
    }

    //search internet with the default search app
    private fun searchNet(barCode: BarCode) {
        try {
            val intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, barCode.barCode)
            activity?.startActivity(intent)
        } catch (exception: ActivityNotFoundException) {
            exception.printStackTrace()
            activity?.let { searchNetCompat(it, barCode) }
        }
    }

    //search internet with the browser if there's no default search app
    private fun searchNetCompat(activity: FragmentActivity, barCode: BarCode) {
        try {
            val uri = Uri.parse(activity.getString(R.string.uri) + barCode.barCode)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            activity.startActivity(intent)
        } catch (exception: ActivityNotFoundException) {
            exception.printStackTrace()
            showToast(activity, activity.getString(R.string.error))
        }
    }
}