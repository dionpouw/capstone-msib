package com.aldion.capstonemsib.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.sql.Time
import java.util.*

@Parcelize
data class Transaction(
    val id:Int,
    val transactionTime:Time //still need checking
):Parcelable
