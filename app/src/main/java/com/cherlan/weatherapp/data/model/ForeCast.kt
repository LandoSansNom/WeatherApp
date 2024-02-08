package com.cherlan.weatherapp.data.model


import com.google.gson.annotations.SerializedName

data class ForeCast(
    @SerializedName("city")
    val city: City? = City(),
    @SerializedName("cnt")
    val cnt: Int? = 0,
    @SerializedName("cod")
    val cod: String? = "",
    @SerializedName("list")
    val list: List<WeatherModel?>? = listOf(),
    @SerializedName("message")
    val message: Int? = 0
)