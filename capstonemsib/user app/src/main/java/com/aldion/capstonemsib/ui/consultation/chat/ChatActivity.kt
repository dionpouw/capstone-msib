package com.aldion.capstonemsib.ui.consultation.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldion.capstonemsib.data.entity.Psychologist
import com.aldion.capstonemsib.databinding.ActivityChatBinding
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
        val data = intent.getParcelableExtra<Psychologist>("data")
        mDatabase = FirebaseDatabase.getInstance().getReference("psychologist")
        binding?.apply{
            tvUserName.text = data?.name
            Glide.with(this@ChatActivity)
                .load(data?.url)
                .into(imgProfile)
        }
    }
}