package com.aldion.capstonemsib.ui.testscreen.question

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldion.capstonemsib.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {
    private var binding: ActivityQuestionBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }
}