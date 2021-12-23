package com.aldion.capstonemsib.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldion.capstonemsib.R
import com.aldion.capstonemsib.data.entity.Psychologist
import com.aldion.capstonemsib.databinding.FragmentHomeBinding
import com.aldion.capstonemsib.ui.consultation.DetailPsychologistActivity
import com.aldion.capstonemsib.utils.Preferences
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.database.*

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding

    private lateinit var preferences: Preferences
    private lateinit var mDatabase: DatabaseReference
    private var datalist = ArrayList<Psychologist>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = Preferences(requireActivity().applicationContext)
        mDatabase = FirebaseDatabase.getInstance().getReference("psychologist")

        binding?.apply {
            tvName.text = "Halo " + preferences.getValue("name") + ","

            Glide.with(this@HomeFragment)
                .load(preferences.getValue("url"))
                .apply(RequestOptions.circleCropTransform())
                .into(ivProfile)

            rvHomeFragment.layoutManager = LinearLayoutManager(requireContext().applicationContext)
            getData()


            ivProfile.setOnClickListener {
                view.findNavController().navigate(R.id.action_navigation_home_to_navigation_profile)
            }
            itemHomeTest.iRight.setOnClickListener {
                Navigation.createNavigateOnClickListener(R.id.action_navigation_home_to_navigation_test)
            }
        }
    }

    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                datalist.clear()
                for (getDataSnapshot in snapshot.children) {
                    val psychologist = getDataSnapshot.getValue(Psychologist::class.java)
                    datalist.add(psychologist!!)
                }

                binding?.apply {
                    if (datalist.isNotEmpty()) {
                        rvHomeFragment.adapter = HomeAdapter(datalist) {
                            val intent = Intent(
                                context,
                                DetailPsychologistActivity::class.java
                            ).putExtra("data", it)
                            startActivity(intent)
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "" + error.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}