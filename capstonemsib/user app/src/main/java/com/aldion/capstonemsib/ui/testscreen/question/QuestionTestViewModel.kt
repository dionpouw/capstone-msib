package com.aldion.capstonemsib.ui.testscreen.question

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.aldion.capstonemsib.data.entity.Statement
import com.aldion.capstonemsib.data.remote.FirebaseCallback
import com.aldion.capstonemsib.data.remote.RemoteStatementRepository
import com.aldion.capstonemsib.data.remote.Response
import com.aldion.capstonemsib.data.room.LocalStatementRepository
import kotlinx.coroutines.Dispatchers

class QuestionTestViewModel(private val remoteStatementRepository: RemoteStatementRepository = RemoteStatementRepository()) : ViewModel() {

    fun getResponseUsingCallback(callback: FirebaseCallback) {
        remoteStatementRepository.getResponseFromRealtimeDatabaseUsingCallback(callback)
    }

    fun getResponseUsingLiveData() : LiveData<Response> {
        return remoteStatementRepository.getResponseFromRealtimeDatabaseUsingLiveData()
    }

    val responseLiveData = liveData(Dispatchers.IO) {
        emit(remoteStatementRepository.getResponseFromRealtimeDatabaseUsingCoroutines())
    }
}