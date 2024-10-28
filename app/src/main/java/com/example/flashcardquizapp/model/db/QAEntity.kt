package com.example.flashcardquizapp.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "qaentity")
data class QAEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val question: String,
    val answer: String
)
