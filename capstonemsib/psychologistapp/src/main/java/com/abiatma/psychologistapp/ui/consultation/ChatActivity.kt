package com.abiatma.psychologistapp.ui.consultation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abiatma.psychologistapp.databinding.ActivityChatBinding
import com.abiatma.psychologistapp.entity.User
import com.bumptech.glide.Glide
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ChatActivity : AppCompatActivity() {
    private var binding: ActivityChatBinding? = null
    lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val data = intent.getParcelableExtra<User>("data")
        mDatabase = FirebaseDatabase.getInstance().getReference("User")

        binding?.apply{
            tvUserName.text = data?.name
            Glide.with(this@ChatActivity)
                .load(data?.url)
                .into(imgProfile)
        }
    }
}