package com.aldion.capstonemsib.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aldion.capstonemsib.databinding.FragmentHomeBinding
import com.aldion.capstonemsib.ui.testscreen.TestFragment
import com.aldion.capstonemsib.utils.Preferences
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding

    private lateinit var preferences: Preferences
    private lateinit var mDatabase : DatabaseReference
    //private var datalist = ArrayList<>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = Preferences(requireActivity().applicationContext)
        mDatabase = FirebaseDatabase.getInstance().getReference("Psychology")

        binding?.apply {
            tvName.text = preferences.getValue("name")

            Glide.with(this@HomeFragment)
                .load(preferences.getValue("url"))
                .apply(RequestOptions.circleCropTransform())
                .into(ivProfile)

            Log.v("test", "url "+preferences.getValues("url"))

            itemHomeTest.iRight.setOnClickListener(){
                val intent = Intent(activity, TestFragment::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}