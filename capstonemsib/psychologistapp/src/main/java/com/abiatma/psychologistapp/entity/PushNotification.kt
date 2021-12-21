package com.abiatma.psychologistapp.entity

import com.codingwithme.firebasechat.model.NotificationData

data class PushNotification(
    var data: NotificationData,
    var to:String
)