package com.abiatma.psychologistapp.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.abiatma.psychologistapp.databinding.FragmentProfileBinding
import com.abiatma.psychologistapp.ui.signin.SignInActivity
import com.abiatma.psychologistapp.utils.Preferences
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding

    lateinit var preferences: Preferences

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

//        datalist.add(Transaction(1,"2021-2101"))
//        listTransaction.setTransaction(datalist)
        binding?.apply {
            tvProfilName.text = preferences.getValue("name")
            tvProfilEmail.text = preferences.getValue("email")
            tvUsername.text = preferences.getValue("username")

            Glide.with(this@ProfileFragment)
                .load(preferences.getValue("url"))
                .apply(RequestOptions.circleCropTransform())
                .into(imgProfile)
//            btnEdit.setOnClickListener { view ->
//                view.findNavController().navigate(R.id.action_navigation_profile_to_profileEditFragment)
//            }

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