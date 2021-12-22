package com.aldion.capstonemsib.ui.consultation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldion.capstonemsib.data.entity.Psychologist
import com.aldion.capstonemsib.databinding.ActivityDetailPsychologistBinding
import com.bumptech.glide.Glide
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DetailPsychologistActivity : AppCompatActivity() {

    lateinit var mDatabase: DatabaseReference

    private var binding: ActivityDetailPsychologistBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPsychologistBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val data = intent.getParcelableExtra<Psychologist>("data")

        mDatabase = FirebaseDatabase.getInstance().getReference("psychologist")

        binding?.apply {
            tvName.text = data?.name
            tvType.text = data?.type
            tvWorkExperience.text = data?.workExperience
            tvAlumni.text = data?.alumni
            tvPracticePlace.text = data?.practicePlace
            tvSTRNumber.text = data?.noSTR

            Glide.with(this@DetailPsychologistActivity)
                .load(data?.url)
                .into(imgPsychologist)

            btnChat.setOnClickListener {
                val intent = Intent(
                    this@DetailPsychologistActivity,
                    ChatActivity::class.java).putExtra("data", data)
                startActivity(intent)
            }

        }
    }
}