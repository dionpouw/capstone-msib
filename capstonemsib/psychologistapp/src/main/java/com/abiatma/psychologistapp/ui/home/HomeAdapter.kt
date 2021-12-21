package com.abiatma.psychologistapp.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abiatma.psychologistapp.R
import com.abiatma.psychologistapp.entity.User
import com.bumptech.glide.Glide

class HomeAdapter(
    private var data: List<User>,
    private val listener: (User) -> Unit
) : RecyclerView.Adapter<HomeAdapter.ListViewHolder>() {

    private lateinit var contextAdapter: Context

    class ListViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        private val tvName: TextView = view.findViewById(R.id.userName)

        private val tvImage: ImageView = view.findViewById(R.id.userImage)

        fun bindItem(data: User, listener: (User) -> Unit, context: Context) {

            tvName.text = data.name

            Glide.with(context)
                .load(data.url)
                .into(tvImage)

            itemView.setOnClickListener {
                listener(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView: View =
            layoutInflater.inflate(R.layout.item_chat, parent, false)

        return ListViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindItem(data[position], listener, contextAdapter)
    }

    override fun getItemCount(): Int = data.size
}
