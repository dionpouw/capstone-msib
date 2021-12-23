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
    val opt1: String? = null,

    @ColumnInfo(name = "optB")
    val opt2: String? = null,

    @ColumnInfo(name = "optC")
    val opt3: String? = null,

    @ColumnInfo(name = "optD")
    val opt4: String? = null
) : Parcelable