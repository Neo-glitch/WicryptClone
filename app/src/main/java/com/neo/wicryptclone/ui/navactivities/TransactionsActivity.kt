package com.neo.wicryptclone.ui.navactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.neo.wicryptclone.R
import com.neo.wicryptclone.databinding.ActivityTransactionsBinding
import com.neo.wicryptclone.utilities.TransactionsRvAdapter
import com.neo.wicryptclone.viewmodel.TransactionViewModel

class TransactionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTransactionsBinding
    private val mViewModel by lazy {
        ViewModelProvider(this)[TransactionViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = "Transactions"
        mViewModel.getTransactions()

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = binding.rvTransactions

        val adapter = TransactionsRvAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        divider.setDrawable(resources.getDrawable(R.drawable.rv_item_divider))
        recyclerView.addItemDecoration(divider)
        recyclerView.adapter = adapter


        mViewModel.mLiveTransactionList.observe(this, Observer {
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
        })
    }
}