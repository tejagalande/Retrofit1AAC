package com.example.retrofit1aac

import androidx.lifecycle.MutableLiveData
import retrofit2.Response

class MainRepository(private val api: API) {

    suspend fun getData() : Response <List<Model>>{
        return api.getData()
    }
}