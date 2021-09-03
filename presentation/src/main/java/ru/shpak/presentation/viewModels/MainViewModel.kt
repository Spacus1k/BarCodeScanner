package ru.shpak.presentation.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.shpak.domain.BarCodeInteractor
import ru.shpak.domain.model.BarCode
import javax.inject.Inject

class MainViewModel @Inject constructor(private val interactor: BarCodeInteractor) : ViewModel() {

    val barCodes = MutableLiveData<List<BarCode>>()

    init {
        loadBarCodes()
    }

    fun addBarCode(barCodeValue: String) {
        viewModelScope.launch {
            interactor.addBarCode(barCodeValue)
        }
    }

    fun removeBarCodeById(id: Long) {
        viewModelScope.launch {
            interactor.removeBarCodeById(id)
        }
    }

    fun loadBarCodes() {
        viewModelScope.launch {
            barCodes.value = interactor.getBarCodeList()
        }
    }

    fun removeAllBarCodes() {
        viewModelScope.launch {
            interactor.removeAllBarCodes()
        }
    }
}