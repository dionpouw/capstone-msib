package com.aldion.capstonemsib.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldion.capstonemsib.databinding.ActivityOnBoardingOneBinding
import com.aldion.capstonemsib.signin.SignInActivity

class OnBoardingOneActivity : AppCompatActivity() {
    private lateinit var onBoardingOneBinding: ActivityOnBoardingOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBoardingOneBinding = ActivityOnBoardingOneBinding.inflate(layoutInflater)
        setContentView(onBoardingOneBinding.root)

        onBoardingOneBinding.apply {
            btnNext.setOnClickListener() {
                val intentNext =
                    Intent(this@OnBoardingOneActivity, OnBoardingTwoActivity::class.java)
                startActivity(intentNext)
            }

            btnSkip.setOnClickListener() {
                val intentSkip = Intent(this@OnBoardingOneActivity, SignInActivity::class.java)
                startActivity(intentSkip)
            }
        }
    }
}