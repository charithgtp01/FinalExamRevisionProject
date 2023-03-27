package com.example.allinoneproject

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserViewModelProviderFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val userDao = UserApp.userDatabase.userDao()
        val userService = UserApp.retrofit.create(ApiInterface::class.java)
        val userRepository = UserRepositoryImpl(userDao = userDao, userService = userService)
        val viewModel=UserViewModel(userRepository)
        return viewModel as T
    }
}