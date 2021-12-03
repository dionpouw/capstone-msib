package com.aldion.capstonemsib.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldion.capstonemsib.databinding.ActivitySignUpBinding
import com.aldion.capstonemsib.ui.signin.SignInActivity
import com.aldion.capstonemsib.ui.signin.User
import com.google.firebase.database.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var signUpBinding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(signUpBinding.root)

        signUpBinding.apply {
            btnSignUp.setOnClickListener(){
                suUsername = edtUsername.text.toString()
                suPassword = edtPassword.text.toString()
                suPassword = edtPassword.text.toString()
            }
            btnSignIn.setOnClickListener(){
                val intentSignUp = Intent(this@SignUpActivity, SignInActivity::class.java)
                startActivity(intentSignUp)
            }
        }
    }
}