package com.aldion.capstonemsib.data.entity

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "user")
data class User (
    var email: String? = "",
    var name: String? = "",
    var password: String? = "",
    var dateOfBirth: String? = "",
    var url: String? = "",
    var username: String? = "",
    var telephoneNumber: String? = ""
) : Parcelable