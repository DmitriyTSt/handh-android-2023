package ru.dmitriyt.lesson7.data

import retrofit2.http.GET
import ru.dmitriyt.lesson7.data.model.Bridge

interface MainApiService {

    @GET("bridges1")
    suspend fun getBridges(): List<Bridge>
}