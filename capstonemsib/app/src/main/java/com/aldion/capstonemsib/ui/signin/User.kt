package com.aldion.capstonemsib.ui.signin

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var email: String? = "",
    var name: String? = "",
    var password: String? = "",
    var dateOfBirth: String? = "",
    var url: String? = "",
    var username: String? = "",
    val telephoneNumber:String? = ""
) : Parcelable