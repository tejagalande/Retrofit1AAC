package com.example.retrofit1aac

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Model(

    @SerializedName("theater_name")
    val name : String,

    @SerializedName("address")
    val address : String,

    @SerializedName("contact")
    val phone : Long
) : Serializable
