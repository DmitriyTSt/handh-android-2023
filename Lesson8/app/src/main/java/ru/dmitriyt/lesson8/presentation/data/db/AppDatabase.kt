package ru.dmitriyt.lesson8.presentation.data.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import ru.dmitriyt.lesson8.presentation.data.db.dao.CarDao
import ru.dmitriyt.lesson8.presentation.data.db.entity.CarEntity

@Database(
    entities = [CarEntity::class],
    version = AppDatabase.VERSION,
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun carDao(): CarDao

    companion object {
        const val NAME = "app_db"
        const val VERSION = 2

        val migration1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "alter table ${CarEntity.TABLE_NAME} add `color` TEXT NOT NULL default ``"
                )
            }
        }
    }
}