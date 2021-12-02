package com.aldion.capstonemsib.ui.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldion.capstonemsib.databinding.ActivitySignInBinding
import com.aldion.capstonemsib.ui.signup.SignUpActivity
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

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