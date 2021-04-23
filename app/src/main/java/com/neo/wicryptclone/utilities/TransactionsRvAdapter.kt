package com.neo.wicryptclone.utilities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.neo.wicryptclone.R
import com.neo.wicryptclone.model.Transaction
import org.w3c.dom.Text
import java.util.*

class TransactionsRvAdapter :
    ListAdapter<Transaction, TransactionsRvAdapter.TransactionsViewHolder>(diffUtilCallback) {

    companion object {
        var diffUtilCallback = object : DiffUtil.ItemCallback<Transaction>() {
            override fun areItemsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
                return oldItem.amount == newItem.amount
            }

            override fun areContentsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
                return Objects.equals(oldItem, newItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_transactions, parent, false)
        return TransactionsViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionsViewHolder, position: Int) {
        val transaction = getItem(position)
        if(transaction != null){
            holder.bind(transaction)
        }
    }

    class TransactionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mTransactionAmount: TextView by lazy {
            itemView.findViewById<TextView>(R.id.transaction_amount)
        }
        private val mTransactionDateTime: TextView by lazy {
            itemView.findViewById<TextView>(R.id.transaction_date_time)
        }

        fun bind(transaction: Transaction) {
            mTransactionAmount.text = transaction.amount
            mTransactionDateTime.text = transaction.dateTime
        }


    }
}
