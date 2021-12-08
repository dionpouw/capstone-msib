package com.aldion.capstonemsib.ui.listpsycholog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldion.capstonemsib.databinding.ActivityDetailPsychologistBinding

class DetailPsychologistActivity : AppCompatActivity() {
    private var binding: ActivityDetailPsychologistBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPsychologistBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }
}