package ru.dmitriyt.lesson8.presentation.data.db

import android.content.Context
import androidx.room.Room
import ru.dmitriyt.lesson8.presentation.data.db.dao.CarDao

object DatabaseClient {

    private var db: AppDatabase? = null

    fun carDao(context: Context): CarDao {
        return getInstance(context).carDao()
    }

    private fun getInstance(context: Context): AppDatabase {
        return db ?: run {
            val db = Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.NAME)
                .addMigrations(AppDatabase.migration1_2)
                .build()
            this.db = db
            db
        }
    }
}