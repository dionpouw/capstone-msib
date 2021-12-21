package com.abiatma.psychologistapp.entity

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "user")
data class User (
    var email: String? = "",
    var name: String? = "",
    var url: String? = "",
    var username: String? = "",
) : Parcelable