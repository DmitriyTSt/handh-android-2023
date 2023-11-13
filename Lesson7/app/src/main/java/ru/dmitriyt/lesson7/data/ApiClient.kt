package ru.dmitriyt.lesson7.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val apiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://gdemost.handh.ru:1235/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(MainApiService::class.java)
    }
}