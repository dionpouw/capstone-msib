package com.aldion.capstonemsib.data.room

import android.content.Context
import androidx.lifecycle.LiveData
import com.aldion.capstonemsib.data.entity.Statement

class StatementRepository(private val statementDao: StatementDao) {

    companion object {
        @Volatile
        private var instance: StatementRepository? = null

        fun getInstance(context: Context): StatementRepository {
            return instance ?: synchronized(this) {
                if (instance == null) {
                    val database = StatementDatabase.getInstance(context)
                    instance = StatementRepository(database.statementDao())
                }
                return instance as StatementRepository
            }
        }
    }

    fun getAllStatement(): LiveData<MutableList<Statement?>?>? {
        return statementDao.getAllStatement()
    }

    fun insert(statement: Statement) {
        return statementDao.insert(statement)
    }
}