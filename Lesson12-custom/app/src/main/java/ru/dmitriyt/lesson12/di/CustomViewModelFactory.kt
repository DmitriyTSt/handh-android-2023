package ru.dmitriyt.lesson12.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.dmitriyt.lesson12.presentation.bridges.BridgesViewModel

class CustomViewModelFactory(
    private val applicationComponent: BridgesApplicationComponent,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            BridgesViewModel::class.java -> {
                BridgesViewModel(
                    repository = applicationComponent.provideBridgesRepository(),
                ) as T
            }

            else -> error("Unsupported ViewModel class")
        }
    }
}