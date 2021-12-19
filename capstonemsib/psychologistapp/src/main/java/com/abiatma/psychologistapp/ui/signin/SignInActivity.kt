package com.abiatma.psychologistapp.ui.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.abiatma.psychologistapp.databinding.ActivitySignInBinding
import com.abiatma.psychologistapp.ui.signup.SignUpActivity
import com.abiatma.psychologistapp.entity.Psychologist
import com.abiatma.psychologistapp.ui.home.HomeActivity
import com.abiatma.psychologistapp.utils.Preferences
import com.google.firebase.database.*

class SignInActivity : AppCompatActivity() {
    private var signInBinding: ActivitySignInBinding? = null
    private lateinit var siUsername: String
    private lateinit var siPassword: String

    private lateinit var mDatabase: DatabaseReference
    lateinit var preference: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signInBinding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(signInBinding?.root)

        mDatabase = FirebaseDatabase.getInstance().getReference("psychologist")
        preference = Preferences(this)

        if (preference.getValue("status") == "1") {
            finishAffinity()
            val goHome = Intent(this@SignInActivity, HomeActivity::class.java)
            startActivity(goHome)
        }

        signInBinding?.apply {
            btnSignIn.setOnClickListener {
                siUsername = edtUsername.text.toString()
                siPassword = edtPassword.text.toString()

                if (siUsername == "" || siUsername.isEmpty()) {
                    edtUsername.error = "Silakan masukkan email terlebih dahulu!"
                    edtUsername.requestFocus()
                } else if (siPassword == "" || siPassword.isEmpty()) {
                    edtPassword.error = "Silakan masukkan password terlebih dahulu!"
                    edtPassword.requestFocus()
                } else {
                    pushLogin(siUsername, siPassword)
                }
            }
            btnSignUp.setOnClickListener {
                val intentSignUp = Intent(this@SignInActivity, SignUpActivity::class.java)
                startActivity(intentSignUp)
            }
        }
    }

    private fun pushLogin(siUsername: String, siPassword: String) {
        mDatabase.child(siUsername).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val psychologist = snapshot.getValue(Psychologist::class.java)
                if (psychologist == null) {
                    Toast.makeText(this@SignInActivity, "Akun tidak ditemukan", Toast.LENGTH_LONG)
                        .show()
                } else {
                    if (psychologist.password.equals(siPassword)) {

                        preference.setValue("name", psychologist.name.toString())
                        preference.setValue("username", psychologist.username.toString())
                        preference.setValue("url", psychologist.url.toString())
                        preference.setValue("email", psychologist.email.toString())
                        preference.setValue("password", psychologist.password.toString())
                        preference.setValue("noSTR", psychologist.noSTR.toString())
                        preference.setValue("practicePlace", psychologist.practicePlace.toString())
                        preference.setValue("type", psychologist.type.toString())
                        preference.setValue("workExperience", psychologist.workExperience.toString())
                        preference.setValue("alumni", psychologist.alumni.toString())

                        preference.setValue("status", "1")


                        val intentToHome = Intent(this@SignInActivity, HomeActivity::class.java)
                        startActivity(intentToHome)
                    } else if (psychologist.password != siPassword) {
                        Toast.makeText(
                            this@SignInActivity,
                            "Password kamu salah",
                            Toast.LENGTH_LONG
                        )
                            .show()
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@SignInActivity, error.message, Toast.LENGTH_LONG)
                    .show()
            }
        })
    }
}