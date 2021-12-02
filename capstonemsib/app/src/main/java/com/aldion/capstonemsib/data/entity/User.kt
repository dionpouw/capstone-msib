package com.aldion.capstonemsib.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var email: String? = "",
    var nama: String? = "",
    var password: String? = "",
    var saldo: String? = "",
    var url: String? = "",
    var username: String? = ""
) : Parcelable