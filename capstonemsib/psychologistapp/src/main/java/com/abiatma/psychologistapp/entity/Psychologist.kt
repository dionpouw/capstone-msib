package com.abiatma.psychologistapp.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Psychologist(
    var email: String? = "",
    var name: String? = "",
    var password: String? = "",
    var noSTR: String? = "",
    var url: String? = "",
    var username: String? = "",
    var practicePlace: String? = "",
    var type: String? = "",
    var workExperience: String? = "",
    var alumni: String? = ""
):Parcelable