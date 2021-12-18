package com.aldion.capstonemsib.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aldion.capstonemsib.databinding.FragmentProfileEditBinding
import com.aldion.capstonemsib.utils.Preferences
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.database.DataSnapshot

class ProfileEditFragment : Fragment() {
    private var _binding: FragmentProfileEditBinding? = null
    private val binding get() = _binding

    lateinit var preferences: Preferences

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
        preferences = Preferences(requireContext())

        binding?.apply {
//            edtNameProfile.text = preferences.child("name")
//            edtEmailProfile.text = preferences.getValue("email")
//            edtDateProfile.text = preferences.getValue("dateOfBirth")
//            edtTelephoneProfile.text = preferences.getValue("telephoneNumber")
//            edtUsernameProfile.text = preferences.getValue("username")
//            edtPasswordProfile.text = preferences.getValue("password").toString()

            Glide.with(this@ProfileEditFragment)
                .load(preferences.getValue("url"))
                .apply(RequestOptions.circleCropTransform())
                .into(imgProfile)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}