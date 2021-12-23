package com.aldion.capstonemsib.ui.profile

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.aldion.capstonemsib.R
import com.aldion.capstonemsib.data.entity.User
import com.aldion.capstonemsib.databinding.FragmentProfileEditBinding
import com.aldion.capstonemsib.utils.Preferences
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.*

class ProfileEditFragment : Fragment() {
    private var _binding: FragmentProfileEditBinding? = null
    private val binding get() = _binding

    private lateinit var suUsername: String
    private lateinit var suPassword: String
    private lateinit var suName: String
    private lateinit var suEmail: String
    private lateinit var suTelephoneNumber: String
    private lateinit var suDateOfBirth: String

    private lateinit var mDatabaseReference: DatabaseReference
    private lateinit var mFirebaseInstance: FirebaseDatabase
    lateinit var storageReference: StorageReference
    lateinit var user: User
    lateinit var storage: FirebaseStorage
    lateinit var filePath: Uri
    var statusAdd: Boolean = false

    private lateinit var preferences: Preferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileEditBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        storage = FirebaseStorage.getInstance()
        storageReference = storage.reference

        mFirebaseInstance = FirebaseDatabase.getInstance()
        mDatabaseReference = mFirebaseInstance.getReference("User")

        preferences = Preferences(requireContext())
        binding?.apply {
            edtNameProfile.setText(preferences.getValue("name").toString())
            edtEmailProfile.setText(preferences.getValue("email").toString())
            edtDateProfile.setText(preferences.getValue("dateOfBirth").toString())
            edtTelephoneProfile.setText(preferences.getValue("telephoneNumber").toString())
            edtUsernameProfile.setText(preferences.getValue("username").toString())
            edtPasswordProfile.setText(preferences.getValue("password").toString())

            Glide.with(this@ProfileEditFragment)
                .load(preferences.getValue("url"))
                .apply(RequestOptions.circleCropTransform())
                .into(imgProfile)

            imgBack.setOnClickListener {
                view.findNavController()
                    .navigate(R.id.action_profileEditFragment_to_navigation_profile)
            }

//            ivAdd.setOnClickListener {
//                if (statusAdd) {
//                    statusAdd = false
//                    ivAdd.setImageResource(R.drawable.btn_upload)
//                } else {
//                    ImagePicker.with(this@ProfileEditFragment)
//                        .cameraOnly()    //User can only capture image using Camera
//                        .start()
//                }
//            }

            btnSaveEdit.setOnClickListener {
                suUsername = edtUsernameProfile.text.toString()
                suPassword = edtPasswordProfile.text.toString()
                suName = edtNameProfile.text.toString()
                suEmail = edtEmailProfile.text.toString()
                suTelephoneNumber = edtTelephoneProfile.text.toString()
                suDateOfBirth = edtDateProfile.text.toString()
//                val ref = storageReference.child("images/" + UUID.randomUUID().toString())
//                ref.putFile(filePath)
//                    .addOnSuccessListener {
//                        ref.downloadUrl.addOnSuccessListener {
//                            saveToFirebase(it.toString())
//                        }
//                    }

                if (suUsername == "" || suUsername.isEmpty()) {
                    edtUsernameProfile.error = "Silakan masukkan nama pengguna terlebih dahulu!"
                    edtUsernameProfile.requestFocus()
                } else if (suName == "" || suName.isEmpty()) {
                    edtNameProfile.error = "Silakan masukkan nama terlebih dahulu!"
                    edtNameProfile.requestFocus()
                } else if (suTelephoneNumber == "" || suTelephoneNumber.isEmpty()) {
                    edtTelephoneProfile.error = "Silakan masukkan nomor telephone terlebih dahulu!"
                    edtTelephoneProfile.requestFocus()
                } else if (suDateOfBirth == "" || suDateOfBirth.isEmpty()) {
                    edtDateProfile.error = "Silakan masukkan tanggal lahir terlebih dahulu!"
                    edtDateProfile.requestFocus()
                } else if (suEmail == "" || suEmail.isEmpty()) {
                    edtEmailProfile.error = "Silakan masukkan email terlebih dahulu!"
                    edtEmailProfile.requestFocus()
                } else if (suPassword == "" || suPassword.isEmpty()) {
                    edtPasswordProfile.error = "Silakan masukkan password terlebih dahulu!"
                    edtPasswordProfile.requestFocus()
                } else {
                    val statusUsername = suUsername.indexOf(".")
                    if (statusUsername >= 0) {
                        edtUsernameProfile.error = "Silahkan tulis Username Anda tanpa ."
                        edtUsernameProfile.requestFocus()
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
        mDatabaseReference.child(suUsername)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    mDatabaseReference.child(suUsername).setValue(data)
                    preferences.setValue("email", data.email.toString())
                    preferences.setValue("name", data.name.toString())
                    preferences.setValue("dateOfBirth", data.dateOfBirth.toString())
                    preferences.setValue("telephoneNumber", data.telephoneNumber.toString())
                    preferences.setValue("username", data.username.toString())
                    preferences.setValue("password", data.password.toString())

                    view?.findNavController()
                        ?.navigate(R.id.action_profileEditFragment_to_navigation_profile)
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(activity, "" + error.message, Toast.LENGTH_LONG).show()
                }
            })
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        when (resultCode) {
//            Activity.RESULT_OK -> {
//                //Image Uri will not be null for RESULT_OK
//                statusAdd = true
//                filePath = data?.data!!
//
//                binding?.apply {
//                    Glide.with(this@ProfileEditFragment)
//                        .load(filePath)
//                        .apply(RequestOptions.circleCropTransform())
//                        .into(imgProfile)
//
//                    ivAdd.setImageResource(R.drawable.btn_delete_upload)
//                }
//            }
//            ImagePicker.RESULT_ERROR -> {
//                Toast.makeText(activity, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
//            }
//            else -> {
//                Toast.makeText(activity, "Task Cancelled", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}