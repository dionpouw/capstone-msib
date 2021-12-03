package com.aldion.capstonemsib.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldion.capstonemsib.databinding.ActivitySignUpBinding
import com.aldion.capstonemsib.ui.signin.SignInActivity
import com.aldion.capstonemsib.data.entity.User
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

    private fun saveUsername(
        suUsername: String,
        suPassword: String,
        suName: String,
        suEmail: String
    ) {
        val user = User()
        user.email = suEmail
        user.username = suUsername
        user.name = suName
        user.password = suPassword

        checkingUsername(suUsername, user)
    }

    private fun checkingUsername(suUsername: String, data: User) {
        mDatabaseReference.child(suUsername).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(User::class.java)
                if (user == null) {
                    mDatabaseReference.child(suUsername).setValue(data)

                    val intentSignIn = Intent(this@SignUpActivity, SignInActivity::class.java)
                    startActivity(intentSignIn)

                } else {
                    Toast.makeText(this@SignUpActivity, "Akun kamu berhasil didaftarkan", Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@SignUpActivity, "" + error.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}