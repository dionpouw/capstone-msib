package com.aldion.capstonemsib.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldion.capstonemsib.databinding.ActivityOnBoardingThreeBinding
import com.aldion.capstonemsib.ui.signin.SignInActivity

class OnBoardingThreeActivity : AppCompatActivity() {
    private var onBoardingThreeBinding: ActivityOnBoardingThreeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBoardingThreeBinding = ActivityOnBoardingThreeBinding.inflate(layoutInflater)
        setContentView(onBoardingThreeBinding?.root)

        onBoardingThreeBinding?.apply {
            btnNext.setOnClickListener(){
                finishAffinity()

                val intentNext = Intent(this@OnBoardingThreeActivity, SignInActivity::class.java)
                startActivity(intentNext)
            }
        }
    }
}