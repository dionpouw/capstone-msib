package com.aldion.capstonemsib.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aldion.capstonemsib.data.entity.Statement

@Dao
interface StatementDao {
    @Query("SELECT * from statement_table")
    fun getAllStatement():LiveData<MutableList<Statement>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(statement: List<Statement>)
}