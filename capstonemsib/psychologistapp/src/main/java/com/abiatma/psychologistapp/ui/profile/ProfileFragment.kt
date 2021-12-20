package com.abiatma.psychologistapp.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.abiatma.psychologistapp.R
import com.abiatma.psychologistapp.databinding.FragmentProfileBinding
import com.abiatma.psychologistapp.ui.signin.SignInActivity
import com.abiatma.psychologistapp.utils.Preferences
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding

    private lateinit var preferences: Preferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        preferences = Preferences(requireContext())

        binding?.apply {
            tvProfilName.text = preferences.getValue("name")
            tvType.text = preferences.getValue("type")
            tvWorkExperience.text = preferences.getValue("workExperience")
            tvAlumni.text = preferences.getValue("alumni")
            tvPracticePlace.text = preferences.getValue("practicePlace")
            tvSTRNumber.text = preferences.getValue("noSTR")

            Glide.with(this@ProfileFragment)
                .load(preferences.getValue("url"))
                .apply(RequestOptions.circleCropTransform())
                .into(imgProfile)
            btnEdit.setOnClickListener { view ->
                view.findNavController().navigate(R.id.action_navigation_profiles_to_profileEditFragment)
            }

            btnLogOut.setOnClickListener(){
                preferences.setValue("status", "0")
                activity?.finish()
                val intent = Intent(activity, SignInActivity::class.java)
                startActivity(intent)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}