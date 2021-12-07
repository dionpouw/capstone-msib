package com.aldion.capstonemsib.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Psycholog(
    val id:Int,
    val name:String,
    val experienceYear:Int,
    val consultationPrice:Int,
    val imagePath:String
):Parcelable