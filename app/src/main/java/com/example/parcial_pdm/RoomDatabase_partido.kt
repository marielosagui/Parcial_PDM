package com.example.parcial_pdm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.parcial_pdm.dao.partidoDao
import com.example.parcial_pdm.entities.partido

@Database(entities = [partido::class], version = 2, exportSchema = false)
abstract class RoomDatabase_partido : RoomDatabase() {
    abstract fun partidoDa() : partidoDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDatabase_partido? = null

        fun getDatabase(
            context: Context
        ): RoomDatabase_partido {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDatabase_partido::class.java,
                    "partido_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}