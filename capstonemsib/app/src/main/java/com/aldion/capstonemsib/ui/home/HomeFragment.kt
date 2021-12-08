package com.aldion.capstonemsib.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldion.capstonemsib.R
import com.aldion.capstonemsib.data.entity.Psycholog
import com.aldion.capstonemsib.databinding.FragmentHomeBinding
import com.aldion.capstonemsib.utils.Preferences
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding
    private var listPsycholog = HomeAdapter()

    private lateinit var preferences: Preferences
    private lateinit var mDatabase: DatabaseReference
    private var datalist = ArrayList<Psycholog>()

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

        datalist.add(Psycholog(1,"Aldion",2021,2000000,"adsasd"))
        listPsycholog.setPsycholog(datalist)
        binding?.apply {
            //tvName.text = preferences.getValue("name")
            tvName.text = getString(R.string.hi_natasya)

            Glide.with(this@HomeFragment)
                .load(preferences.getValue("url"))
                .apply(RequestOptions.circleCropTransform())
                .into(ivProfile)

            Log.v("test", "url " + preferences.getValue("url"))

            rvHomeFragment.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = listPsycholog
            }


            itemHomeTest.iRight.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_navigation_home_to_navigation_test)
                //change intent to navigation
            )
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}