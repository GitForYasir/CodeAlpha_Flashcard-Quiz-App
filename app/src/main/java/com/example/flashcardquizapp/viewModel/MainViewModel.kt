package com.example.flashcardquizapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.flashcardquizapp.model.db.QADao
import com.example.flashcardquizapp.model.db.QADatabase
import com.example.flashcardquizapp.model.db.QAEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FlashcardViewModel(application: Application) : AndroidViewModel(application) {
    private val dao: QADao = QADatabase.getDatabase(application).dao
    private val _flashcards = MutableStateFlow<List<QAEntity>>(emptyList())

    val flashcards: StateFlow<List<QAEntity>> = _flashcards

    init {
        viewModelScope.launch {
            dao.getAllQA().collect { list ->
                _flashcards.value = list
            }
        }
    }

    fun insertFlashcard(qaEntity: QAEntity) {
        viewModelScope.launch {
            dao.insertQA(qaEntity)
        }
    }
}



class FlashcardViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FlashcardViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FlashcardViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
