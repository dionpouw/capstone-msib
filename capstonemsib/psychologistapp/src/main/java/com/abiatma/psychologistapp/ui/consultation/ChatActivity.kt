package com.abiatma.psychologistapp.ui.consultation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abiatma.psychologistapp.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {
    private var binding: ActivityChatBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }
}