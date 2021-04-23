package com.neo.wicryptclone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.neo.wicryptclone.model.Transaction

class TransactionViewModel: ViewModel() {

    var mLiveTransactionList: MutableLiveData<MutableList<Transaction>> = MutableLiveData()

    fun getTransactions(){
        var mTransactionList: MutableList<Transaction> = mutableListOf()
        mTransactionList.add(Transaction("+ 992.5 NGN", "08/09/2021 15:20"))
        mTransactionList.add(Transaction("+ 10,000.0 NGN", "09/09/2021 23:20"))
        mTransactionList.add(Transaction("+ 20,000.0 NGN", "10/09/2021 12:20"))
        mLiveTransactionList.value = mTransactionList
    }

}