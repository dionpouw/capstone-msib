package com.aldion.capstonemsib.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldion.capstonemsib.databinding.ActivityOnBoardingTwoBinding
import com.aldion.capstonemsib.ui.signin.SignInActivity

class OnBoardingTwoActivity : AppCompatActivity() {
    private var onBoardingTwoBinding: ActivityOnBoardingTwoBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBoardingTwoBinding = ActivityOnBoardingTwoBinding.inflate(layoutInflater)
        setContentView(onBoardingTwoBinding?.root)

        onBoardingTwoBinding?.apply {
            btnNext.setOnClickListener() {
                val intentNext =
                    Intent(this@OnBoardingTwoActivity, OnBoardingThreeActivity::class.java)
                startActivity(intentNext)
            }

            btnSkip.setOnClickListener() {
                val intentSkip = Intent(this@OnBoardingTwoActivity, SignInActivity::class.java)
                startActivity(intentSkip)
            }
        }
    }
}