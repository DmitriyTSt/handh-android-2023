package ru.dmitriyt.lesson12.di

import dagger.Module
import dagger.Provides
import ru.dmitriyt.lesson12.data.repository.BridgesRepository
import ru.dmitriyt.lesson12.data.repository.BridgesRepository2Impl
import ru.dmitriyt.lesson12.data.repository.BridgesRepositoryImpl
import kotlin.random.Random

@Module
class RepositoryModule {

    @Provides
    fun provideBridgesRepository(
        bridgesRepository: BridgesRepositoryImpl,
        bridgesRepository2: BridgesRepository2Impl,
    ): BridgesRepository {
        return if (Random.nextInt() % 2 == 0) {
            bridgesRepository
        } else {
            bridgesRepository2
        }
    }
}