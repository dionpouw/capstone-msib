package com.aldion.capstonemsib.ui.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aldion.capstonemsib.data.entity.Transaction
import com.aldion.capstonemsib.databinding.ItemProfilHistoryBinding

class ProfileAdapter : RecyclerView.Adapter<ProfileAdapter.ListViewHolder>() {
    private var listTransaction = ArrayList<Transaction>()

    fun setTransaction(transaction: List<Transaction>) {
        this.listTransaction.clear()
        this.listTransaction.addAll(transaction)
    }

    inner class ListViewHolder(private val binding: ItemProfilHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(transaction: Transaction) {
//            with(binding) {
//                tvNamePsycholog.text = transaction.id.toString()
//                tvProfilDate.text = transaction.transactionTime
//                tvPricePsycholog.text = transaction.transactionTime
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ItemProfilHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val transaction = listTransaction[position]
        holder.bind(transaction)
    }

    override fun getItemCount(): Int = listTransaction.size
}