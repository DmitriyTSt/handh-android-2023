package ru.dmitriyt.lesson12.data.repository

import ru.dmitriyt.lesson12.data.remote.MainApiService
import ru.dmitriyt.lesson12.data.remote.model.toModel
import ru.dmitriyt.lesson12.presentation.Bridge

class BridgesRepository(
    private val apiService: MainApiService,
) {

    suspend fun getBridges(): List<Bridge> {
        return apiService.getBridges().map { it.toModel() }
    }
}