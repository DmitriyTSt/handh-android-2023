package ru.dmitriyt.lesson12.presentation

import androidx.annotation.LayoutRes
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModel
import dagger.android.support.DaggerFragment
import ru.dmitriyt.lesson12.di.DaggerViewModelFactory
import javax.inject.Inject

abstract class BaseFragment(@LayoutRes layoutRes: Int) : DaggerFragment(layoutRes) {

    @Inject lateinit var daggerViewModelFactory: DaggerViewModelFactory

    protected inline fun <reified VM : ViewModel> appViewModels() = createViewModelLazy(VM::class, { viewModelStore }) {
        daggerViewModelFactory
    }
}