package com.aldion.capstonemsib.ui.signup

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.aldion.capstonemsib.data.entity.User
import com.aldion.capstonemsib.databinding.ActivitySignUpPhotoScreenBinding
import com.aldion.capstonemsib.utils.Preferences
import com.aldion.capstonemsib.R
import com.aldion.capstonemsib.ui.home.HomeActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.*

class SignUpPhotoScreenActivity : AppCompatActivity(){
    private var binding: ActivitySignUpPhotoScreenBinding? = null

    var statusAdd:Boolean = false
    lateinit var filePath: Uri

    lateinit var storage: FirebaseStorage
    lateinit var storageReference: StorageReference
    lateinit var preferences: Preferences

    lateinit var user : User
    private lateinit var mFirebaseDatabase: DatabaseReference
    private lateinit var mFirebaseInstance: FirebaseDatabase


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpPhotoScreenBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        preferences = Preferences(this)
        storage = FirebaseStorage.getInstance()
        storageReference = storage.reference

        mFirebaseInstance = FirebaseDatabase.getInstance()
        mFirebaseDatabase = mFirebaseInstance.getReference("User")

        binding?.apply {
            user = intent.getParcelableExtra("data")!!
            tvWelcome.text = "Selamat datang "+user.name

            ivAdd.setOnClickListener {
                if (statusAdd) {
                    statusAdd = false
                    btnSignUp.visibility = View.INVISIBLE
                    ivAdd.setImageResource(R.drawable.btn_upload)
                    imgProfile.setImageResource(R.drawable.profil_blue)

                } else {
                    ImagePicker.with(this@SignUpPhotoScreenActivity)
                        .cameraOnly()	//User can only capture image using Camera
                        .start()
                }
            }

            btnUploadLater.setOnClickListener {

                finishAffinity()

                val intent = Intent(this@SignUpPhotoScreenActivity,
                    HomeActivity::class.java)
                startActivity(intent)
            }

            btnSignUp.setOnClickListener {
                if (filePath != null) {
                    val progressDialog = ProgressDialog(this@SignUpPhotoScreenActivity)
                    progressDialog.setTitle("Uploading...")
                    progressDialog.show()

                    val ref = storageReference.child("images/" + UUID.randomUUID().toString())
                    ref.putFile(filePath)
                        .addOnSuccessListener {
                            progressDialog.dismiss()
                            Toast.makeText(this@SignUpPhotoScreenActivity, "Uploaded", Toast.LENGTH_SHORT).show()
                            ref.downloadUrl.addOnSuccessListener {
                                saveToFirebase(it.toString())
                            }
                        }
                        .addOnFailureListener { e ->
                            progressDialog.dismiss()
                            Toast.makeText(this@SignUpPhotoScreenActivity, "Failed " + e.message, Toast.LENGTH_SHORT).show()
                        }
                        .addOnProgressListener { taskSnapshot ->
                            val progress = 100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount
                            progressDialog.setMessage("Uploaded " + progress.toInt() + "%")
                        }
                }
            }
        }
    }

    override fun onBackPressed() {
        Toast.makeText(this, "Tergesah? Klik tombol Upload Nanti saja", Toast.LENGTH_LONG ).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode) {
            Activity.RESULT_OK -> {
                //Image Uri will not be null for RESULT_OK
                statusAdd = true
                filePath = data?.data!!

                binding?.apply {
                    Glide.with(this@SignUpPhotoScreenActivity)
                        .load(filePath)
                        .apply(RequestOptions.circleCropTransform())
                        .into(imgProfile)


                    btnSignUp.visibility = View.VISIBLE
                    ivAdd.setImageResource(R.drawable.btn_delete_upload)
                }
            }
            ImagePicker.RESULT_ERROR -> {
                Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveToFirebase(url: String) {

        mFirebaseDatabase.child(user.username!!).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                user.url = url
                mFirebaseDatabase.child(user.username!!).setValue(user)

                preferences.setValue("name", user.name.toString())
                preferences.setValue("user", user.username.toString())
                preferences.setValue("url", "")
                preferences.setValue("email", user.email.toString())
                preferences.setValue("dateOfBirth", user.dateOfBirth.toString())
                preferences.setValue("telephoneNumber", user.telephoneNumber.toString())
                preferences.setValue("status", "1")
                preferences.setValue("url", url)

                finishAffinity()
                val intent = Intent(this@SignUpPhotoScreenActivity,
                    HomeActivity::class.java)
                startActivity(intent)

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@SignUpPhotoScreenActivity, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}