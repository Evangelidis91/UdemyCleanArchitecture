package com.evangelidis.udemycleanarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.evangelidis.udemycleanarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainActivityViewModelFactory(125)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)

        viewModel.totalData.observe(this, Observer {
            binding.totalAmount.text = it.toString()
        })

        binding.addButton.setOnClickListener {
            viewModel.updateAmount(binding.inputValue.text.toString())
            binding.inputValue.text.clear()
        }
    }

}