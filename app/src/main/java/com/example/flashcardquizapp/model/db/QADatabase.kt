package com.example.flashcardquizapp.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [QAEntity::class], version = 1)
abstract class QADatabase : RoomDatabase() {
    abstract val dao: QADao

    companion object {
        @Volatile
        private var INSTANCE: QADatabase? = null

        fun getDatabase(context: Context): QADatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QADatabase::class.java,
                    "qa_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
