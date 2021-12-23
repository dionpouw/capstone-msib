package com.aldion.capstonemsib.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.aldion.capstonemsib.data.entity.Statement
import com.aldion.capstonemsib.utils.SetData
import java.util.concurrent.Executors

@Database(entities = [Statement::class], version = 1, exportSchema = false)
abstract class StatementDatabase : RoomDatabase() {

    abstract fun statementDao(): StatementDao

    companion object {
        @Volatile
        private var INSTANCE: StatementDatabase? = null

        fun getInstance(context: Context): StatementDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StatementDatabase::class.java,
                    "statement.db"
                ).addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        INSTANCE?.let {
                            Executors.newSingleThreadExecutor().execute {
                                populateDbAsyncTask(it.statementDao())
                            }
                        }
                    }
                }).build()
                INSTANCE = instance
                instance
            }
        }

        private fun populateDbAsyncTask(statementDao: StatementDao) {
            statementDao.insert(
                SetData.getQuestion()
            )
        }
    }
}