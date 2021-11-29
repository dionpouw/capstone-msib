package com.aldion.capstonemsib.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldion.capstonemsib.databinding.ActivityOnBoardingThreeBinding
import com.aldion.capstonemsib.signin.SignInActivity

class OnBoardingThreeActivity : AppCompatActivity() {
    private lateinit var onBoardingThreeBinding: ActivityOnBoardingThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBoardingThreeBinding = ActivityOnBoardingThreeBinding.inflate(layoutInflater)
        setContentView(onBoardingThreeBinding.root)

        onBoardingThreeBinding.apply {
            btnNext.setOnClickListener(){
                val intentNext = Intent(this@OnBoardingThreeActivity, SignInActivity::class.java)
                startActivity(intentNext)
            }
        }
    }
}