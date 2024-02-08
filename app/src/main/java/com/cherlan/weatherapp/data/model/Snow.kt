package com.cherlan.weatherapp.data.model


import com.google.gson.annotations.SerializedName

data class Snow(
    @SerializedName("3h")
    val h: Double? = 0.0
)