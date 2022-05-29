package com.example.retrofit1aac

import androidx.lifecycle.MutableLiveData
import retrofit2.Response
import retrofit2.http.GET

interface API {

    @GET("getDetails")
    suspend fun getData() : Response<List<Model>> // using livedata
   // suspend fun getData() : Response<List<Model>> // using mutable livedata
}