package com.abiatma.psychologistapp.ui.profile

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.abiatma.psychologistapp.R
import com.abiatma.psychologistapp.databinding.FragmentProfileEditBinding
import com.abiatma.psychologistapp.entity.Psychologist
import com.abiatma.psychologistapp.utils.Preferences
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class ProfileEditFragment : Fragment() {
    private var _binding: FragmentProfileEditBinding? = null
    private val binding get() = _binding

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
    lateinit var storageReference: StorageReference
    lateinit var psychologist: Psychologist
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
            edtNoSTRProfile.setText(preferences.getValue("noSTR").toString())
            edtPracticePlaceProfile.setText(preferences.getValue("practicePlace").toString())
            edtUsernameProfile.setText(preferences.getValue("username").toString())
            edtPasswordProfile.setText(preferences.getValue("password").toString())
            edtTypeProfile.setText(preferences.getValue("type").toString())
            edtWorkExperienceProfile.setText(preferences.getValue("workExperience").toString())
            edtAlumniProfile.setText(preferences.getValue("alumni").toString())

            Glide.with(this@ProfileEditFragment)
                .load(preferences.getValue("url"))
                .apply(RequestOptions.circleCropTransform())
                .into(imgProfile)

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
                suNoSTR = edtNoSTRProfile.text.toString()
                suPracticePlace = edtPracticePlaceProfile.text.toString()
                suType = edtTypeProfile.text.toString()
                suWorkExperience = edtWorkExperienceProfile.text.toString()
                suAlumni = edtAlumniProfile.text.toString()

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
                } else if (suNoSTR == "" || suNoSTR.isEmpty()) {
                    edtNoSTRProfile.error = "Silakan masukkan nomor telephone terlebih dahulu!"
                    edtNoSTRProfile.requestFocus()
                } else if (suPracticePlace == "" || suPracticePlace.isEmpty()) {
                    edtPracticePlaceProfile.error = "Silakan masukkan tanggal lahir terlebih dahulu!"
                    edtPracticePlaceProfile.requestFocus()
                } else if (suEmail == "" || suEmail.isEmpty()) {
                    edtEmailProfile.error = "Silakan masukkan email terlebih dahulu!"
                    edtEmailProfile.requestFocus()
                } else if (suPassword == "" || suPassword.isEmpty()) {
                    edtPasswordProfile.error = "Silakan masukkan password terlebih dahulu!"
                    edtPasswordProfile.requestFocus()
                } else if (suType == "" || suType.isEmpty()) {
                    edtTypeProfile.error = "Silakan masukkan password terlebih dahulu!"
                    edtTypeProfile.requestFocus()
                } else if (suWorkExperience == "" || suWorkExperience.isEmpty()) {
                    edtWorkExperienceProfile.error = "Silakan masukkan password terlebih dahulu!"
                    edtWorkExperienceProfile.requestFocus()
                } else if (suAlumni == "" || suAlumni.isEmpty()) {
                    edtAlumniProfile.error = "Silakan masukkan password terlebih dahulu!"
                    edtAlumniProfile.requestFocus()
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
                            suNoSTR,
                            suPracticePlace,
                            suType,
                            suWorkExperience,
                            suAlumni
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
        psychologist.noSTR = suNoSTR
        psychologist.practicePlace = suPracticePlace
        psychologist.type = suType
        psychologist.workExperience = suWorkExperience
        psychologist.alumni = suAlumni
        checkingUsername(suUsername, psychologist)
    }

    private fun checkingUsername(suUsername: String, data: Psychologist) {
        mDatabaseReference.child(suUsername)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    mDatabaseReference.child(suUsername).setValue(data)
                    preferences.setValue("email", data.email.toString())
                    preferences.setValue("name", data.name.toString())
                    preferences.setValue("noSTR", data.noSTR.toString())
                    preferences.setValue("practicePlace", data.practicePlace.toString())
                    preferences.setValue("username", data.username.toString())
                    preferences.setValue("password", data.password.toString())
                    preferences.setValue("type", data.type.toString())
                    preferences.setValue("workExperience", data.workExperience.toString())
                    preferences.setValue("alumni", data.alumni.toString())

                    view?.findNavController()
                        ?.navigate(R.id.action_profileEditFragment_to_navigation_notifications)
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