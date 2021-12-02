package com.aldion.capstonemsib.ui.signin

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aldion.capstonemsib.databinding.ActivitySignInBinding
import com.aldion.capstonemsib.ui.home.HomeActivity
import com.aldion.capstonemsib.ui.signup.SignUpActivity
import com.aldion.capstonemsib.utils.Preferences
import com.google.firebase.database.*

class SignInActivity : AppCompatActivity() {
    private lateinit var signInBinding: ActivitySignInBinding
    private lateinit var iUsername: String
    private lateinit var iPassword: String

    lateinit var mDatabase: DatabaseReference
    lateinit var preference: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signInBinding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(signInBinding.root)

        mDatabase = FirebaseDatabase.getInstance().getReference("User")
        preference = Preferences(this)

        preference.setValue("onboarding", "1")
        if (preference.getValue("status") == "1"){
            finishAffinity()

            val goHome = Intent(this@SignInActivity, HomeActivity::class.java)
            startActivity(goHome)
        }

        signInBinding.apply {
            btnSignIn.setOnClickListener() {
                iUsername = edtUsername.text.toString()
                iPassword = edtPassword.text.toString()

                if (iUsername == "" || iUsername.isEmpty()) {
                    edtUsername.error = "Silakan masukkan email terlebih dahulu!"
                    edtUsername.requestFocus()
                } else if (iPassword == "" || iPassword.isEmpty()) {
                    edtPassword.error = "Silakan masukkan password terlebih dahulu!"
                    edtPassword.requestFocus()
                } else {
                    pushLogin(iUsername, iPassword)
                }
            }
            btnSignUp.setOnClickListener() {
                val intentSignUp = Intent(this@SignInActivity, SignUpActivity::class.java)
                startActivity(intentSignUp)
            }
        }
    }

    private fun pushLogin(iUsername: String, iPassword: String) {
        mDatabase.child(iUsername).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(User::class.java)
                if (user == null) {
                    Toast.makeText(this@SignInActivity, "Akun tidak ditemukan", Toast.LENGTH_LONG)
                        .show()
                } else {
                    if(user.password.equals(iPassword)){

                        preference.setValue("nama", user.nama.toString())
                        preference.setValue("username", user.username.toString())
                        preference.setValue("url", user.url.toString())
                        preference.setValue("email", user.email.toString())
                        preference.setValue("saldo", user.saldo.toString())
                        preference.setValue("status", "1")


                        val intentToHome = Intent(this@SignInActivity, HomeActivity::class.java)
                        startActivity(intentToHome)
                    } else if (user.password != iPassword){
                        Toast.makeText(this@SignInActivity, "Password kamu salah", Toast.LENGTH_LONG)
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