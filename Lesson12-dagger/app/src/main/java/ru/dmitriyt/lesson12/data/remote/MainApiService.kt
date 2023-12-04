package ru.dmitriyt.lesson12.data.remote

import retrofit2.http.GET
import ru.dmitriyt.lesson12.data.remote.model.ApiBridge

interface MainApiService {

    @GET("bridges")
    suspend fun getBridges(): List<ApiBridge>
}