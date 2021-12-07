package com.aldion.capstonemsib.ui.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldion.capstonemsib.databinding.ActivitySignUpPhotoScreenBinding

class SignUpPhotoScreenActivity : AppCompatActivity() {
    private var signUpBinding: ActivitySignUpPhotoScreenBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = ActivitySignUpPhotoScreenBinding.inflate(layoutInflater)
        setContentView(signUpBinding?.root)
    }
}