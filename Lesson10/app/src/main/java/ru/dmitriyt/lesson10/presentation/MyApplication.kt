package ru.dmitriyt.lesson10.presentation

import android.app.Application
import com.yandex.mapkit.MapKitFactory
import ru.dmitriyt.lesson10.R

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey(getString(R.string.yandex_map_api_key))
        MapKitFactory.initialize(this)
    }
}