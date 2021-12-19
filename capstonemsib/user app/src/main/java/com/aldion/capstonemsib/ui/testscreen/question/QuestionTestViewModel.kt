package com.aldion.capstonemsib.ui.testscreen.question

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aldion.capstonemsib.data.entity.Statement
import com.aldion.capstonemsib.data.room.StatementRepository

class QuestionTestViewModel(private val statementRepository: StatementRepository) : ViewModel() {

    private val _question = MutableLiveData<ArrayList<Statement>>()

    val question: LiveData<ArrayList<Statement>> = _question

    fun getAllStatement() {
        statementRepository.getAllStatement()
    }
}