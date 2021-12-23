package com.aldion.capstonemsib.ui.testscreen.result

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aldion.capstonemsib.R
import com.aldion.capstonemsib.databinding.ActivityResultTestBinding
import com.aldion.capstonemsib.ui.home.HomeActivity
import com.aldion.capstonemsib.ui.testscreen.TestFragment

class ResultTestActivity : AppCompatActivity() {
    private var _binding: ActivityResultTestBinding? = null
    private val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityResultTestBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val scoreTest = intent.getIntExtra("TEST_RESULT", 0)

        if (scoreTest <= 10){
            binding!!.tvDescResultTest.text = getString(R.string.desc_normal_result_test)
        }
            binding?.apply {
                btnBackToTest.setOnClickListener {
                    val intentBackToTest = Intent(this@ResultTestActivity, TestFragment::class.java)
                    startActivity(intentBackToTest)
                }

                btnConsultation.setOnClickListener {
                    val intentConsultation =
                        Intent(this@ResultTestActivity, HomeActivity::class.java)
                    startActivity(intentConsultation)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val TEST_RESULT = 0
    }
}