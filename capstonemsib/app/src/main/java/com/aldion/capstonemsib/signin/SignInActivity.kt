package com.aldion.capstonemsib.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldion.capstonemsib.databinding.ActivitySignInBinding
import com.aldion.capstonemsib.signup.SignUpActivity

class SignInActivity : AppCompatActivity() {
    private lateinit var signInBinding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signInBinding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(signInBinding.root)

        signInBinding.apply {
            btnSignUp.setOnClickListener(){
                val intentSignUp = Intent(this@SignInActivity, SignUpActivity::class.java)
                startActivity(intentSignUp)
            }
        }
    }
}