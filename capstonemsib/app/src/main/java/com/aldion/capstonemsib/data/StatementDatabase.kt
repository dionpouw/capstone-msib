package com.aldion.capstonemsib.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.aldion.capstonemsib.data.room.StatementDao
import java.util.concurrent.Executors

@Database(entities = [Statement::class], version = 1)
abstract class StatementDatabase : RoomDatabase() {

    abstract fun statementDao(): StatementDao?

}