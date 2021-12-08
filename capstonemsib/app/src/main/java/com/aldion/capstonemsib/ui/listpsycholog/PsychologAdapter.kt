package com.aldion.capstonemsib.ui.listpsycholog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aldion.capstonemsib.data.entity.Psychologist
import com.aldion.capstonemsib.databinding.ItemPsychologBinding
import com.bumptech.glide.Glide

class PsychologAdapter : RecyclerView.Adapter<PsychologAdapter.ListViewHolder>() {
    private var listPsycholog = ArrayList<Psychologist>()

    fun setPsycholog(psychologist: List<Psychologist>) {
        this.listPsycholog.clear()
        this.listPsycholog.addAll(psychologist)
    }

    inner class ListViewHolder(private val binding: ItemPsychologBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(psychologist: Psychologist) {
//            with(binding) {
//                tvNameShow.text = psychologist.name
//                tvPricePsycholog.text = psychologist.consultationPrice.toString()
//                Glide.with(itemView.context)
//                    .load(psychologist.imagePath)
//                    .into(imageView)
//            }
        }
    }

    override fun getItemCount(): Int = listPsycholog.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ItemPsychologBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val psycholog = listPsycholog[position]
        holder.bind(psycholog)
    }
}