package com.aldion.capstonemsib.ui.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aldion.capstonemsib.R
import com.aldion.capstonemsib.data.entity.Psychologist
import com.aldion.capstonemsib.ui.consultation.DetailPsychologistActivity
import com.aldion.capstonemsib.ui.consultation.chat.ChatActivity
import com.bumptech.glide.Glide

class HomeAdapter(
    private var data: List<Psychologist>,
    private val listener: (Psychologist) -> Unit
) : RecyclerView.Adapter<HomeAdapter.ListViewHolder>() {

    private lateinit var contextAdapter: Context

    class ListViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        private val tvName: TextView = view.findViewById(R.id.tv_name_show)
        private val tvType: TextView = view.findViewById(R.id.tv_type)
        private val tvExperience: TextView = view.findViewById(R.id.tvExperience)
        private val btnChat: TextView = view.findViewById(R.id.btnChat)

        private val tvImage: ImageView = view.findViewById(R.id.iv_poster_image)

        fun bindItem(data: Psychologist, listener: (Psychologist) -> Unit, context: Context) {

            tvName.text = data.name
            tvType.text = data.type
            tvExperience.text = data.workExperience

            Glide.with(context)
                .load(data.url)
                .into(tvImage)

            itemView.setOnClickListener {
                listener(data)
            }

            btnChat.setOnClickListener {
                val intent = Intent(
                    context,
                    ChatActivity::class.java
                ).putExtra("data", data)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView: View =
            layoutInflater.inflate(R.layout.item_psycholog, parent, false)

        return ListViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindItem(data[position], listener, contextAdapter)
    }

    override fun getItemCount(): Int = data.size
}