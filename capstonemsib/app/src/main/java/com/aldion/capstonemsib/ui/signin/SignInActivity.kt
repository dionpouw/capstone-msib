package com.aldion.capstonemsib.ui.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aldion.capstonemsib.data.entity.User
import com.aldion.capstonemsib.databinding.ActivitySignInBinding
import com.aldion.capstonemsib.ui.home.HomeActivity
import com.aldion.capstonemsib.ui.signup.SignUpActivity
import com.aldion.capstonemsib.utils.Preferences
import com.google.firebase.database.*

class SignInActivity : AppCompatActivity() {
    private  var signInBinding: ActivitySignInBinding? = null
    private lateinit var siUsername: String
    private lateinit var siPassword: String

    private lateinit var mDatabase: DatabaseReference
    lateinit var preference: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signInBinding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(signInBinding?.root)

        mDatabase = FirebaseDatabase.getInstance().getReference("User")
        preference = Preferences(this)

        preference.setValue("onboarding", "1")
        if (preference.getValue("status") == "1"){
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
                val user = snapshot.getValue(User::class.java)
                if (user == null) {
                    Toast.makeText(this@SignInActivity, "Akun tidak ditemukan", Toast.LENGTH_LONG)
                        .show()
                } else {
                    if(user.password.equals(siPassword)){

                        preference.setValue("name", user.name.toString())
                        preference.setValue("username", user.username.toString())
                        preference.setValue("url", user.url.toString())
                        preference.setValue("email", user.email.toString())
                        preference.setValue("dateOfBirth", user.dateOfBirth.toString())
                        preference.setValue("telephoneNumber", user.telephoneNumber.toString())
                        preference.setValue("status", "1")


                        val intentToHome = Intent(this@SignInActivity, HomeActivity::class.java)
                        startActivity(intentToHome)
                    } else if (user.password != siPassword){
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