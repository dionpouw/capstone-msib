package com.aldion.capstonemsib.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aldion.capstonemsib.databinding.ActivitySignUpBinding
import com.aldion.capstonemsib.ui.signin.SignInActivity
import com.aldion.capstonemsib.data.entity.User
import com.google.firebase.database.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var signUpBinding: ActivitySignUpBinding
    private lateinit var suUsername: String
    private lateinit var suPassword: String
    private lateinit var suName: String
    private lateinit var suEmail: String

    private lateinit var mDatabaseReference: DatabaseReference
    private lateinit var mFirebaseInstance: FirebaseDatabase
    private lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(signUpBinding.root)

        mFirebaseInstance = FirebaseDatabase.getInstance()
        mDatabase = FirebaseDatabase.getInstance().reference
        mDatabaseReference = mFirebaseInstance.getReference("User")

        signUpBinding.apply {
            btnSignUp.setOnClickListener() {
                suUsername = edtUsername.text.toString()
                suPassword = edtPassword.text.toString()
                suName = edtName.text.toString()
                suEmail = edtEmail.text.toString()

                if (suUsername == "" || suUsername.isEmpty()) {
                    edtUsername.error = "Silakan masukkan nama pengguna terlebih dahulu!"
                    edtUsername.requestFocus()
                } else if (suPassword == "" || suPassword.isEmpty()) {
                    edtPassword.error = "Silakan masukkan password terlebih dahulu!"
                    edtPassword.requestFocus()
                } else if (suName == "" || suName.isEmpty()) {
                    edtName.error = "Silakan masukkan nama terlebih dahulu!"
                    edtName.requestFocus()
                } else if (suEmail == "" || suEmail.isEmpty()) {
                    edtEmail.error = "Silakan masukkan email terlebih dahulu!"
                    edtEmail.requestFocus()
                } else {
                    saveUsername(suUsername, suPassword, suName, suEmail)
                }
            }

            btnSignIn.setOnClickListener() {
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
        user.nama = suName
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
