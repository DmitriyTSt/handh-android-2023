package ru.dmitriyt.lesson12.data.repository

import ru.dmitriyt.lesson12.presentation.Bridge
import javax.inject.Inject

class BridgesRepository2Impl @Inject constructor(
) : BridgesRepository {

    override suspend fun getBridges(): List<Bridge> {
        return emptyList()
    }
}