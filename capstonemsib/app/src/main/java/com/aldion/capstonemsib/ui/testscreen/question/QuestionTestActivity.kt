package com.aldion.capstonemsib.ui.testscreen.question

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldion.capstonemsib.databinding.ActivityQuestionTestBinding

class QuestionTestActivity : AppCompatActivity() {
    private var binding: ActivityQuestionTestBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionTestBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        SetData.getStatement()
    }
}