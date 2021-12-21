package com.abiatma.psychologistapp.ui.consultation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.abiatma.psychologistapp.notification.RetrofitInstance
import com.abiatma.psychologistapp.databinding.ActivityChatBinding
import com.abiatma.psychologistapp.entity.Chat
import com.abiatma.psychologistapp.entity.PushNotification
import com.abiatma.psychologistapp.entity.User
import com.abiatma.psychologistapp.utils.Preferences
import com.bumptech.glide.Glide
import com.codingwithme.firebasechat.model.NotificationData
import com.google.firebase.database.*
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.ArrayList

class ChatActivity : AppCompatActivity() {
    private var binding: ActivityChatBinding? = null
    lateinit var mDatabase: DatabaseReference
    private lateinit var preferences: Preferences
    var chatList = ArrayList<Chat>()
    var topic = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        preferences = Preferences(this)
        val data = intent.getParcelableExtra<User>("data")
        mDatabase = FirebaseDatabase.getInstance().getReference("User")

        binding?.apply {
            tvUserName.text = data?.name
            Glide.with(this@ChatActivity)
                .load(data?.url)
                .into(imgProfile)

            chatRecyclerView.layoutManager =
                LinearLayoutManager(this@ChatActivity.applicationContext)

            btnSendMessage.setOnClickListener {
                val message = etMessage.text.toString()

                if (message.isEmpty()) {
                    Toast.makeText(applicationContext, "pesan kosong", Toast.LENGTH_LONG).show()
                } else {
                    sendMessage(
                        preferences.getValue("username").toString(),
                        data?.username!!,
                        message
                    )
                    etMessage.setText("")
                    topic = data?.name!!
                    PushNotification(
                        NotificationData(data.name!!, message),
                        topic
                    ).also {
                        sendNotification(it)
                    }
                }
            }
            readMessage(preferences.getValue("username").toString(), data?.username!!)
        }
    }

    private fun sendMessage(senderId: String, receiverId: String, message: String) {
        val reference: DatabaseReference = FirebaseDatabase.getInstance().reference

        val hashMap: HashMap<String, String> = HashMap()
        hashMap["senderId"] = senderId
        hashMap["receiverId"] = receiverId
        hashMap["message"] = message

        reference.child("Chat").push().setValue(hashMap)
    }

    private fun readMessage(senderId: String, receiverId: String) {
        val databaseReference: DatabaseReference =
            FirebaseDatabase.getInstance().getReference("Chat")

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                chatList.clear()
                for (dataSnapShot: DataSnapshot in snapshot.children) {
                    val chat = dataSnapShot.getValue(Chat::class.java)

                    if (chat!!.senderId.equals(senderId) && chat.receiverId.equals(receiverId) ||
                        chat.senderId.equals(receiverId) && chat.receiverId.equals(senderId)
                    ) {
                        chatList.add(chat)
                    }
                }

                val chatAdapter = ChatAdapter(this@ChatActivity, chatList)

                binding.apply {
                    this?.chatRecyclerView?.adapter = chatAdapter
                }
            }
        })
    }

    private fun sendNotification(notification: PushNotification) =
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitInstance.api.postNotification(notification)
                if (response.isSuccessful) {
                    Log.d("TAG", "Response: ${Gson().toJson(response)}")
                } else {
                    Log.e("TAG", response.errorBody()!!.toString())
                }
            } catch (e: Exception) {
                Log.e("TAG", e.toString())
            }
        }
}