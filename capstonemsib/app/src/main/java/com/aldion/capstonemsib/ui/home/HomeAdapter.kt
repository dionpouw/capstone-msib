package com.aldion.capstonemsib.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aldion.capstonemsib.data.entity.Psycholog
import com.aldion.capstonemsib.databinding.ItemPsychologBinding
import com.bumptech.glide.Glide

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ListViewHolder>() {
    private var listPsycholog = ArrayList<Psycholog>()

    fun setPsycholog(psycholog: List<Psycholog>) {
        this.listPsycholog.clear()
        this.listPsycholog.addAll(psycholog)
    }

    inner class ListViewHolder(private val binding: ItemPsychologBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(psycholog: Psycholog) {
            with(binding) {
                tvNameShow.text = psycholog.name
                tvPricePsycholog.text = psycholog.consultationPrice.toString()
                Glide.with(itemView.context)
                    .load(psycholog.imagePath)
                    .into(imageView)
            }
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