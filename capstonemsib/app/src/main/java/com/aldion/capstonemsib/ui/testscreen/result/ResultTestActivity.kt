package com.aldion.capstonemsib.ui.testscreen.result

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldion.capstonemsib.databinding.ActivityResultTestBinding
import com.aldion.capstonemsib.ui.listpsycholog.PsychologistFragment
import com.aldion.capstonemsib.ui.testscreen.TestFragment

class ResultTestActivity : AppCompatActivity() {
    private var binding: ActivityResultTestBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultTestBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.apply {
            btnBackToTest.setOnClickListener{
                val intentBackToTest = Intent(this@ResultTestActivity, TestFragment::class.java)
                startActivity(intentBackToTest)
            }

            btnConsultation.setOnClickListener{
                val intentConsultation = Intent(this@ResultTestActivity, PsychologistFragment::class.java)
                startActivity(intentConsultation)
            }
        }
    }
}