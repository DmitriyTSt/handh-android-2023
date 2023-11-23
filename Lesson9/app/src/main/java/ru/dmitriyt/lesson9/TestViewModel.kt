package ru.dmitriyt.lesson9

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class TestViewModel : ViewModel() {

    private val _numberLiveData = MutableLiveData<LoadState<Int>>()
    val numberLiveData: LiveData<LoadState<Int>> = _numberLiveData

    fun testJob() {
        viewModelScope.launch {
            _numberLiveData.postValue(LoadState.Loading())
            try {
                delay(3000)
                _numberLiveData.postValue(LoadState.Data(Random.nextInt()))
            } catch (e: Exception) {
                _numberLiveData.postValue(LoadState.Error(e))
            }
        }
    }
}