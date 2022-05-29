package com.example.retrofit1aac

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class MainViewModelFactory(val api : API) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(MainRepository(api)) as T
        throw IllegalArgumentException("Unknown class called")
    }
}