package com.abiatma.psychologistapp.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.abiatma.psychologistapp.databinding.FragmentHomeBinding
import com.abiatma.psychologistapp.entity.User
import com.abiatma.psychologistapp.ui.consultation.ChatActivity
import com.abiatma.psychologistapp.utils.Preferences
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.database.*

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding

    private lateinit var preferences: Preferences
    private lateinit var mDatabase: DatabaseReference
    private var datalist = ArrayList<User>()

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
        mDatabase = FirebaseDatabase.getInstance().getReference("User")

        binding?.apply {
            tvName.text = "Halo " + preferences.getValue("name") + ","

            Glide.with(this@HomeFragment)
                .load(preferences.getValue("url"))
                .apply(RequestOptions.circleCropTransform())
                .into(ivProfile)

            rvHomeFragment.layoutManager = LinearLayoutManager(requireContext().applicationContext)
            getData()
        }
    }

    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                datalist.clear()
                for (getDataSnapshot in snapshot.children){
                    val user =getDataSnapshot.getValue(User::class.java)
                    datalist.add(user!!)
                }

                binding?.apply {
                    if (datalist.isNotEmpty()) {
                        rvHomeFragment.adapter = HomeAdapter(datalist) {
                            val intent = Intent(
                                context,
                                ChatActivity::class.java
                            ).putExtra("data", it)
                            startActivity(intent)
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}