package ru.dmitriyt.lesson12.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.dmitriyt.lesson12.presentation.bridges.BridgesFragment

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun bridgesFragment(): BridgesFragment
}