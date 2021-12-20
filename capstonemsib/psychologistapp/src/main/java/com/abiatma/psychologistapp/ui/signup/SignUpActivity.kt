package com.abiatma.psychologistapp.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.abiatma.psychologistapp.databinding.ActivitySignUpBinding
import com.abiatma.psychologistapp.entity.Psychologist
import com.abiatma.psychologistapp.ui.signin.SignInActivity
import com.abiatma.psychologistapp.utils.Preferences
import com.google.firebase.database.*

class SignUpActivity : AppCompatActivity() {
    private var signUpBinding: ActivitySignUpBinding? = null
    private lateinit var suUsername: String
    private lateinit var suPassword: String
    private lateinit var suName: String
    private lateinit var suEmail: String
    private lateinit var suNoSTR: String
    private lateinit var suPracticePlace: String
    private lateinit var suType: String
    private lateinit var suWorkExperience: String
    private lateinit var suAlumni: String

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
                suNoSTR = edtNoSTR.text.toString()
                suPracticePlace = edtPracticePlace.text.toString()
                suType = edtType.text.toString()
                suWorkExperience = edtWorkExperience.text.toString()
                suAlumni = edtAlumni.text.toString()

                if (suUsername == "" || suUsername.isEmpty()) {
                    edtUsername.error = "Silakan masukkan nama pengguna terlebih dahulu!"
                    edtUsername.requestFocus()
                } else if (suName == "" || suName.isEmpty()) {
                    edtName.error = "Silakan masukkan nama terlebih dahulu!"
                    edtName.requestFocus()
                } else if (suNoSTR == "" || suNoSTR.isEmpty()) {
                    edtNoSTR.error = "Silakan masukkan nomor telephone terlebih dahulu!"
                    edtNoSTR.requestFocus()
                } else if (suPracticePlace == "" || suPracticePlace.isEmpty()) {
                    edtPracticePlace.error = "Silakan masukkan tanggal lahir terlebih dahulu!"
                    edtPracticePlace.requestFocus()
                } else if (suEmail == "" || suEmail.isEmpty()) {
                    edtEmail.error = "Silakan masukkan email terlebih dahulu!"
                    edtEmail.requestFocus()
                } else if (suPassword == "" || suPassword.isEmpty()) {
                    edtPassword.error = "Silakan masukkan password terlebih dahulu!"
                    edtPassword.requestFocus()
                } else if (suType == "" || suType.isEmpty()) {
                    edtType.error = "Silakan masukkan password terlebih dahulu!"
                    edtType.requestFocus()
                } else if (suWorkExperience == "" || suWorkExperience.isEmpty()) {
                    edtWorkExperience.error = "Silakan masukkan password terlebih dahulu!"
                    edtWorkExperience.requestFocus()
                } else if (suAlumni == "" || suAlumni.isEmpty()) {
                    edtAlumni.error = "Silakan masukkan password terlebih dahulu!"
                    edtAlumni.requestFocus()
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
                            suNoSTR,
                            suPracticePlace,
                            suType,
                            suWorkExperience,
                            suAlumni
                        )
                    }

                    btnSignIn.setOnClickListener {
                        val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                        startActivity(intent)
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
        suNoSTR: String,
        suPracticePlace: String,
        suType: String,
        suWorkExperience: String,
        suAlumni: String
    ) {
        val psychologist = Psychologist()
        psychologist.email = suEmail
        psychologist.username = suUsername
        psychologist.name = suName
        psychologist.password = suPassword
        psychologist.type = suType
        psychologist.workExperience = suWorkExperience
        psychologist.alumni = suAlumni
        psychologist.noSTR = suNoSTR
        psychologist.practicePlace = suPracticePlace
        checkingUsername(this.suUsername, psychologist)
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
                    preferences.setValue("type", data.type.toString())
                    preferences.setValue("workExperience", data.workExperience.toString())
                    preferences.setValue("alumni", data.alumni.toString())
                    preferences.setValue("noSTR", data.noSTR.toString())
                    preferences.setValue("practicePlace", data.practicePlace.toString())
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