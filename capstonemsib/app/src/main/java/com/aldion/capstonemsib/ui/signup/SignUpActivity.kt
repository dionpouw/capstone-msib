package com.aldion.capstonemsib.ui.signup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aldion.capstonemsib.data.entity.User
import com.aldion.capstonemsib.databinding.ActivitySignUpBinding
import com.aldion.capstonemsib.utils.Preferences
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
    private lateinit var mDatabase: DatabaseReference

    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(signUpBinding?.root)

        mFirebaseInstance = FirebaseDatabase.getInstance()
        mDatabase = FirebaseDatabase.getInstance().reference
        mDatabaseReference = mFirebaseInstance.getReference("User")

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
        val user = User()
        user.email = suEmail
        user.username = suUsername
        user.name = suName
        user.password = suPassword
        user.telephoneNumber = suTelephoneNumber
        user.dateOfBirth = suDateOfBirth
        checkingUsername(suUsername, user)
    }

    private fun checkingUsername(suUsername: String, data: User) {
        mDatabaseReference.child(suUsername).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(User::class.java)
                if (user == null) {
                    mDatabaseReference.child(suUsername).setValue(data)

                    preferences.setValue("email", data.email.toString())
                    preferences.setValue("name", data.name.toString())
                    preferences.setValue("dateOfBirth", data.dateOfBirth.toString())
                    preferences.setValue("telephoneNumber", data.telephoneNumber.toString())
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