package com.aldion.capstonemsib.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldion.capstonemsib.R
import com.aldion.capstonemsib.data.entity.Psycholog
import com.aldion.capstonemsib.data.entity.Transaction
import com.aldion.capstonemsib.databinding.FragmentProfileBinding
import com.aldion.capstonemsib.databinding.FragmentTestBinding
import com.aldion.capstonemsib.ui.home.HomeAdapter
import com.aldion.capstonemsib.utils.Preferences
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding

    lateinit var preferences: Preferences

    private var listTransaction = ProfileAdapter()

    private var datalist = ArrayList<Transaction>()

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

        datalist.add(Transaction(1,"2021-2101"))
        listTransaction.setTransaction(datalist)
        binding?.apply {

            tvProfilName.text = preferences.getValue("name")
            tvProfilEmail.text = preferences.getValue("email")
            tvProfilDateBirth.text = preferences.getValue("dateOfBirth")
            tvProfilPhone.text = preferences.getValue("telephoneNumber")
            tvUsername.text = preferences.getValue("username")


            Glide.with(this@ProfileFragment)
                .load(preferences.getValue("url"))
                .apply(RequestOptions.circleCropTransform())
                .into(imgProfile)


            rvProfileHistory.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = listTransaction
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}