package ru.dmitriyt.lesson12

import android.app.Application
import ru.dmitriyt.lesson12.di.BridgesApplicationComponent

class BridgesApplication : Application() {

    lateinit var applicationComponent: BridgesApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = BridgesApplicationComponent.getInstance(this)
    }
}