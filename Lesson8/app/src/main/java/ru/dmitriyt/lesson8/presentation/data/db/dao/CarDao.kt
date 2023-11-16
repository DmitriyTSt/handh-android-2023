package ru.dmitriyt.lesson8.presentation.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.dmitriyt.lesson8.presentation.data.db.entity.CarEntity

@Dao
interface CarDao {

    @Insert
    suspend fun save(car: CarEntity)

    @Query("delete from ${CarEntity.TABLE_NAME} where id = :id")
    suspend fun deleteById(id: String)

    @Delete
    suspend fun delete(car: CarEntity)

    @Query("select * from ${CarEntity.TABLE_NAME}")
    suspend fun getCars(): List<CarEntity>

    @Query("select * from ${CarEntity.TABLE_NAME}")
    fun getCarsFlow(): Flow<List<CarEntity>>
}