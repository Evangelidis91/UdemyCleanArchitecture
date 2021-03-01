package com.evangelidis.udemycleanarchitecture

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int) : ViewModel() {

    private var total = MutableLiveData<Int>()

    val totalData: LiveData<Int>
        get() = total

    init {
        total.value = startingTotal
    }

    fun updateAmount(amount: String) {
        total.value = total.value?.plus(amount.toInt())
    }
}