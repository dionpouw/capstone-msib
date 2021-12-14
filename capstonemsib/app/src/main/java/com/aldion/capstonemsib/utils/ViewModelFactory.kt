package com.aldion.capstonemsib.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aldion.capstonemsib.data.room.StatementRepository
import com.aldion.capstonemsib.ui.testscreen.question.QuestionTestViewModel

class ViewModelFactory private constructor(private val statementRepository: StatementRepository) :
    ViewModelProvider.Factory {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory = instance ?: synchronized(this) {
            instance ?: ViewModelFactory(StatementRepository.getInstance(context))
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(QuestionTestViewModel::class.java) -> {
                QuestionTestViewModel(statementRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel Class : " + modelClass.name)
        }
}