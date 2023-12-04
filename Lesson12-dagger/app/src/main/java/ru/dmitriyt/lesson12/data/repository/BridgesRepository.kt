package ru.dmitriyt.lesson12.data.repository

import ru.dmitriyt.lesson12.presentation.Bridge

interface BridgesRepository {

    /** Получить мосты */
    suspend fun getBridges(): List<Bridge>
}