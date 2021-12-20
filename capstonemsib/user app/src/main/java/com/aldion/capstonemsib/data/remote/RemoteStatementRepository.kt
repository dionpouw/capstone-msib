package com.aldion.capstonemsib.data.remote

import androidx.lifecycle.MutableLiveData
import com.aldion.capstonemsib.data.entity.Statement
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

class RemoteStatementRepository(
    private val questionRef: DatabaseReference = FirebaseDatabase.getInstance().getReference("Question")
) {
    fun getResponseFromRealtimeDatabaseUsingCallback(callback: FirebaseCallback) {
        questionRef.get().addOnCompleteListener { task ->
            val response = Response()
            if (task.isSuccessful) {
                val result = task.result
                result?.let {
                    response.questions = result.children.map { snapShot ->
                        snapShot.getValue(Statement::class.java)!!
                    }
                }
            } else {
                response.exception = task.exception
            }
            callback.onResponse(response)
        }
    }

    fun getResponseFromRealtimeDatabaseUsingLiveData(): MutableLiveData<Response> {
        val mutableLiveData = MutableLiveData<Response>()
        questionRef.get().addOnCompleteListener { task ->
            val response = Response()
            if (task.isSuccessful) {
                val result = task.result
                result?.let {
                    response.questions = result.children.map { snapShot ->
                        snapShot.getValue(Statement::class.java)!!
                    }
                }
            } else {
                response.exception = task.exception
            }
            mutableLiveData.value = response
        }
        return mutableLiveData
    }

    suspend fun getResponseFromRealtimeDatabaseUsingCoroutines(): Response {
        val response = Response()
        try {
            response.questions = questionRef.get().await().children.map { snapShot ->
                snapShot.getValue(Statement::class.java)!!
            }
        } catch (exception: Exception) {
            response.exception = exception
        }
        return response
    }
}