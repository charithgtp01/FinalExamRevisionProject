package com.example.allinoneproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.allinoneproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private val viewModel: UserViewModel by viewModels()
    /** ----  After creating ViewModelFactory  ----- */
    val viewModel: UserViewModel by lazy {
        val viewModelProviderFactory = UserViewModelProviderFactory()
        ViewModelProvider(this, viewModelProviderFactory)[UserViewModel::class.java]
    }
    /** ----  After creating ViewModelFactory  ----- */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.userVM = viewModel
        binding.lifecycleOwner = this

        binding.button.setOnClickListener {
            viewModel.getUsers()
        }


    }
}