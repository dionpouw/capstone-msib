package com.aldion.capstonemsib.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "statement_table")
data class Statement(

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "optA")
    val optA: String,

    @ColumnInfo(name = "optB")
    val optB: String,

    @ColumnInfo(name = "optC")
    val optC: String,

    @ColumnInfo(name = "optD")
    val optD: String
)