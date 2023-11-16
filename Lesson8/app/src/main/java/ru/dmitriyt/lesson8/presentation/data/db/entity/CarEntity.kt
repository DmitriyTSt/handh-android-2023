package ru.dmitriyt.lesson8.presentation.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = CarEntity.TABLE_NAME)
data class CarEntity(
    @PrimaryKey val id: String,
    val type: String,
    val model: String,
    val color: String,
    val number: String,
) {
    companion object {
        const val TABLE_NAME = "cars"
    }
}
