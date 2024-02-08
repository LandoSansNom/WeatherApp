package com.cherlan.weatherapp.data.model


import com.google.gson.annotations.SerializedName

data class WeatherModel(
    @SerializedName("clouds")
    val clouds: Clouds? = Clouds(),
    @SerializedName("dt")
    val dt: Int? = 0,
    @SerializedName("dt_txt")
    val dtTxt: String? = "",
    @SerializedName("main")
    val main: Main? = Main(),
    @SerializedName("pop")
    val pop: Double? = 0.0,
    @SerializedName("snow")
    val snow: Snow? = Snow(),
    @SerializedName("sys")
    val sys: Sys? = Sys(),
    @SerializedName("visibility")
    val visibility: Int? = 0,
    @SerializedName("weather")
    val weather: List<Weather?>? = listOf(),
    @SerializedName("wind")
    val wind: Wind? = Wind()
)