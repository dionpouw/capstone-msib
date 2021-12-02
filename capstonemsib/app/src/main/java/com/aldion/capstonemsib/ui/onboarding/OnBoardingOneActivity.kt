package com.aldion.capstonemsib.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldion.capstonemsib.databinding.ActivityOnBoardingOneBinding
import com.aldion.capstonemsib.ui.signin.SignInActivity
import com.aldion.capstonemsib.utils.Preferences

class OnBoardingOneActivity : AppCompatActivity() {
    private lateinit var preference: Preferences

    private lateinit var onBoardingOneBinding: ActivityOnBoardingOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBoardingOneBinding = ActivityOnBoardingOneBinding.inflate(layoutInflater)
        setContentView(onBoardingOneBinding.root)

        preference = Preferences(this)

        if (preference.getValue("onboarding") == "1"){
            finishAffinity()

            val intentSkip = Intent(this@OnBoardingOneActivity, SignInActivity::class.java)
            startActivity(intentSkip)
        }

        onBoardingOneBinding.apply {
            btnNext.setOnClickListener() {
                val intentNext =
                    Intent(this@OnBoardingOneActivity, OnBoardingTwoActivity::class.java)
                startActivity(intentNext)
            }

            btnSkip.setOnClickListener() {
                preference.setValue("onboarding", "1")
                finishAffinity()

                val intentSkip = Intent(this@OnBoardingOneActivity, SignInActivity::class.java)
                startActivity(intentSkip)
            }
        }
    }
}