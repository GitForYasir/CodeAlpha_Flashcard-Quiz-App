package com.example.flashcardquizapp.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QADao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQA(qaEntity: QAEntity)

    @Query("SELECT * FROM qaentity")
    fun getAllQA(): Flow<List<QAEntity>>

    @Query("SELECT * FROM qaentity WHERE id = :id")
    fun getQAById(id: Long): Flow<QAEntity?>
}
