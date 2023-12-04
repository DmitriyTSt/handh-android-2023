package ru.dmitriyt.lesson12.presentation.bridges

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.dmitriyt.lesson12.data.repository.BridgesRepository
import ru.dmitriyt.lesson12.presentation.Bridge
import javax.inject.Inject

class BridgesViewModel @Inject constructor(
    private val repository: BridgesRepository,
) : ViewModel() {

    /** Список мостов */
    private val _bridgesLiveData = MutableLiveData<List<Bridge>>()
    val bridgesLiveData: LiveData<List<Bridge>> = _bridgesLiveData

    fun loadBridges() {
        viewModelScope.launch {
            try {
                val bridges = repository.getBridges()
                _bridgesLiveData.postValue(bridges)
            } catch (e: Exception) {
                Log.e("BRIDGES", e.message.orEmpty())
            }
        }
    }
}