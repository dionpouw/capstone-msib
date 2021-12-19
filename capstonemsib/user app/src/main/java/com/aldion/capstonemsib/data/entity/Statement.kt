package com.aldion.capstonemsib.data.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "statement_table")
@Parcelize
data class Statement(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "optA")
    val optA: String,

    @ColumnInfo(name = "optB")
    val optB: String,

    @ColumnInfo(name = "optC")
    val optC: String,

    @ColumnInfo(name = "optD")
    val optD: String
) : Parcelable