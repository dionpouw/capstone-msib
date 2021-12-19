package com.abiatma.psychologistapp.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.abiatma.psychologistapp.databinding.ActivitySignUpBinding
import com.abiatma.psychologistapp.entity.Psychologist
import com.abiatma.psychologistapp.utils.Preferences
import com.google.firebase.database.*

class SignUpActivity : AppCompatActivity() {
    private var signUpBinding: ActivitySignUpBinding? = null
    private lateinit var suUsername: String
    private lateinit var suPassword: String
    private lateinit var suName: String
    private lateinit var suEmail: String
    private lateinit var suTelephoneNumber: String
    private lateinit var suDateOfBirth: String

    private lateinit var mDatabaseReference: DatabaseReference
    private lateinit var mFirebaseInstance: FirebaseDatabase

    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(signUpBinding?.root)

        mFirebaseInstance = FirebaseDatabase.getInstance()
        mDatabaseReference = mFirebaseInstance.getReference("psychologist")

        preferences = Preferences(this)

        signUpBinding?.apply {
            btnSignUp.setOnClickListener {
                suUsername = edtUsername.text.toString()
                suPassword = edtPassword.text.toString()
                suName = edtName.text.toString()
                suEmail = edtEmail.text.toString()
                suTelephoneNumber = edtTelephoneNumber.text.toString()
                suDateOfBirth = edtDateOfBirth.text.toString()

                if (suUsername == "" || suUsername.isEmpty()) {
                    edtUsername.error = "Silakan masukkan nama pengguna terlebih dahulu!"
                    edtUsername.requestFocus()
                } else if (suName == "" || suName.isEmpty()) {
                    edtName.error = "Silakan masukkan nama terlebih dahulu!"
                    edtName.requestFocus()
                } else if (suTelephoneNumber == "" || suTelephoneNumber.isEmpty()) {
                    edtTelephoneNumber.error = "Silakan masukkan nomor telephone terlebih dahulu!"
                    edtTelephoneNumber.requestFocus()
                } else if (suDateOfBirth == "" || suDateOfBirth.isEmpty()) {
                    edtDateOfBirth.error = "Silakan masukkan tanggal lahir terlebih dahulu!"
                    edtDateOfBirth.requestFocus()
                } else if (suEmail == "" || suEmail.isEmpty()) {
                    edtEmail.error = "Silakan masukkan email terlebih dahulu!"
                    edtEmail.requestFocus()
                } else if (suPassword == "" || suPassword.isEmpty()) {
                    edtPassword.error = "Silakan masukkan password terlebih dahulu!"
                    edtPassword.requestFocus()
                } else {
                    val statusUsername = suUsername.indexOf(".")
                    if (statusUsername >= 0) {
                        edtUsername.error = "Silahkan tulis Username Anda tanpa ."
                        edtUsername.requestFocus()
                    } else {
                        saveUsername(
                            suUsername,
                            suPassword,
                            suName,
                            suEmail,
                            suTelephoneNumber,
                            suDateOfBirth
                        )
                    }
                }
            }
        }
    }

    private fun saveUsername(
        suUsername: String,
        suPassword: String,
        suName: String,
        suEmail: String,
        suTelephoneNumber: String,
        suDateOfBirth: String
    ) {
        val psychologist = Psychologist()
        psychologist.email = suEmail
        psychologist.username = suUsername
        psychologist.name = suName
        psychologist.password = suPassword
        checkingUsername(suUsername, psychologist)
    }

    private fun checkingUsername(suUsername: String, data: Psychologist) {
        mDatabaseReference.child(suUsername).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(Psychologist::class.java)
                if (user == null) {
                    mDatabaseReference.child(suUsername).setValue(data)

                    preferences.setValue("email", data.email.toString())
                    preferences.setValue("name", data.name.toString())
                    preferences.setValue("username", data.username.toString())
                    preferences.setValue("password", data.password.toString())
                    preferences.setValue("url", "")
                    preferences.setValue("status", "1")

                    val intentSignUpPhotoScreen = Intent(
                        this@SignUpActivity,
                        SignUpPhotoScreenActivity::class.java
                    ).putExtra("data", data)
                    startActivity(intentSignUpPhotoScreen)

                } else {
                    Toast.makeText(
                        this@SignUpActivity,
                        "Akun kamu berhasil didaftarkan",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@SignUpActivity, "" + error.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}