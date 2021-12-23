package com.aldion.capstonemsib.data.room

import android.content.Context
import androidx.lifecycle.LiveData
import com.aldion.capstonemsib.data.entity.Statement

class LocalStatementRepository(private val statementDao: StatementDao) {

    companion object {
        @Volatile
        private var instance: LocalStatementRepository? = null

        fun getInstance(context: Context): LocalStatementRepository {
            return instance ?: synchronized(this) {
                if (instance == null) {
                    val database = StatementDatabase.getInstance(context)
                    instance = LocalStatementRepository(database.statementDao())
                }
                return instance as LocalStatementRepository
            }
        }
    }

    fun getAllStatement(): LiveData<MutableList<Statement>> {
        return statementDao.getAllStatement()
    }

    fun insert(statement: List<Statement>) {
        return statementDao.insert(statement)
    }
}