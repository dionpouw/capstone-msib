package com.aldion.capstonemsib.ui.testscreen.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldion.capstonemsib.databinding.ActivityResultTestBinding

class ResultTestActivity : AppCompatActivity() {
    private var binding: ActivityResultTestBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultTestBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }
}