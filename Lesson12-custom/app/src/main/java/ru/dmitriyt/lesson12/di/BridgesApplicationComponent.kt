package ru.dmitriyt.lesson12.di

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.dmitriyt.lesson12.data.remote.MainApiService
import ru.dmitriyt.lesson12.data.repository.BridgesRepository

class BridgesApplicationComponent private constructor(context: Context) {

    private val mainApiService: MainApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://gdemost.handh.ru:1235/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(MainApiService::class.java)
    }

    private val bridgesRepository: BridgesRepository by lazy {
        BridgesRepository(
            apiService = provideMainApiService(),
        )
    }

    private val customViewModelFactory: CustomViewModelFactory by lazy {
        CustomViewModelFactory(this)
    }

    fun provideMainApiService(): MainApiService {
        return mainApiService
    }

    fun provideBridgesRepository(): BridgesRepository {
        return bridgesRepository
    }

    fun provideCustomViewModelFactory(): CustomViewModelFactory {
        return customViewModelFactory
    }

    companion object {
        fun getInstance(context: Context): BridgesApplicationComponent {
            return BridgesApplicationComponent(context)
        }
    }
}