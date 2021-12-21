package com.abiatma.psychologistapp.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Chat(
    var senderId: String? = "",
    var receiverId: String? = "",
    var message: String? = ""
): Parcelable