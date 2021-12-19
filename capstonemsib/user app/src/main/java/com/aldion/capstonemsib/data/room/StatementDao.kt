package com.aldion.capstonemsib.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aldion.capstonemsib.data.entity.Statement

@Dao
interface StatementDao {
    @Query("SELECT * FROM statement_table")
    fun getAllStatement(): LiveData<MutableList<Statement?>?>?

    @Insert
    fun insert(statement: Statement?)
}