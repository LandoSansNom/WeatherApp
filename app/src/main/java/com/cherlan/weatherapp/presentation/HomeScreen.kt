package com.cherlan.weatherapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.cherlan.weatherapp.BuildConfig
import com.cherlan.weatherapp.data.model.ForeCast


@Composable
fun CurrentWeather(foreCast: ForeCast){

    Column {
        Text(text = "${foreCast.city?.name} ?: \"City name not available\" , ${foreCast.city?.country} ?: \"Country name not available\"")
    }
}







@Preview
@Composable
fun display(){
    //CurrentWeather()
}