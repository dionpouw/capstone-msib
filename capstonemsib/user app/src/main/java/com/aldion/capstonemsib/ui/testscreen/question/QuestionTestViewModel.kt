package com.aldion.capstonemsib.ui.testscreen.question

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aldion.capstonemsib.data.entity.Statement
import com.aldion.capstonemsib.utils.SetData

class QuestionTestViewModel() :
    ViewModel() {

    private val _question = MutableLiveData<List<Statement>>()

    val question: LiveData<List<Statement>> = _question

    fun getQuestion(){
        _question.value = SetData.getQuestion()
    }
}