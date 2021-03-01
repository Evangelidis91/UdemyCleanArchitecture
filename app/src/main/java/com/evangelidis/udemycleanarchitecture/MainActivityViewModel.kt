package com.evangelidis.udemycleanarchitecture

import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int) : ViewModel() {

    private var total = 0

    init {
        total = startingTotal
    }

    fun getCurrentCount(): String {
        return total.toString()
    }

    fun updateAmount(amount: String) {
        total += amount.toInt()
    }
}