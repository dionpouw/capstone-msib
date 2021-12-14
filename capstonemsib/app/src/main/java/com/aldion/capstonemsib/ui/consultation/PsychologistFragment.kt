package com.aldion.capstonemsib.ui.consultation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldion.capstonemsib.data.entity.Psychologist
import com.aldion.capstonemsib.databinding.FragmentPsychologBinding
import com.aldion.capstonemsib.utils.Preferences
import com.google.firebase.database.*

class PsychologistFragment : Fragment() {

    private var _binding: FragmentPsychologBinding? = null
    private val binding get() = _binding

    private lateinit var preferences: Preferences
    private lateinit var mDatabase: DatabaseReference
    private var datalist = ArrayList<Psychologist>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPsychologBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = Preferences(requireActivity().applicationContext)
        mDatabase = FirebaseDatabase.getInstance().getReference("psychologist")

        binding?.apply {
            rvPsychologist.layoutManager = LinearLayoutManager(requireContext().applicationContext)
            getData()
        }
    }

    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                datalist.clear()
                for (getDataSnapshot in snapshot.children){
                    val psychologist =getDataSnapshot.getValue(Psychologist::class.java)
                    datalist.add(psychologist!!)
                }

                binding?.apply {
                    if (datalist.isNotEmpty()) {
                        rvPsychologist.adapter = PsychologistAdapter(datalist) {
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
                Toast.makeText(context, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}