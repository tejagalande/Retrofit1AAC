package com.example.retrofit1aac

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private val BASE_URL = "http://wimc.patronaidtechnologies.com/api/"


    fun getRetrofit() : Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val api : API = RetrofitService.getRetrofit().create(API::class.java)
}