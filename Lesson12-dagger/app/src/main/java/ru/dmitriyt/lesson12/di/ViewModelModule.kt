package ru.dmitriyt.lesson12.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.dmitriyt.lesson12.presentation.bridges.BridgesViewModel

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(BridgesViewModel::class)
    abstract fun bridgesViewModel(viewModel: BridgesViewModel): ViewModel
}