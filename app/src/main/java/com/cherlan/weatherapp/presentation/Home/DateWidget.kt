package com.cherlan.weatherapp.presentation.Home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cherlan.weatherapp.data.model.WeatherModel

@Composable
fun DateItem(weatherModel: WeatherModel){
    Text(text = weatherModel.dtTxt ?: "No date time available",
        color = Color(184,184,184)
    )
}


@Composable
fun DateItems(weatherModels: List<WeatherModel?>){

    LazyRow(
        contentPadding = PaddingValues(horizontal = 18.dp),
        horizontalArrangement = Arrangement.spacedBy(18.dp)
    ){
        items(weatherModels){weathearmodel->
            DateItem(weatherModel = weathearmodel!!)
        }
    }

}


val weatherModel = WeatherModel(dtTxt = "2024-02-11 18:00:00")

@Preview
@Composable
fun Preview(){
    DateItem(weatherModel = weatherModel)
}