package com.aldion.capstonemsib.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.sql.Time

@Parcelize
data class Transaction(
    val id: Int,
    val transactionTime: String //still need checking
) : Parcelable
