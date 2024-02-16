package com.cherlan.weatherapp.presentation.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.cherlan.weatherapp.data.model.WeatherModel
import com.cherlan.weatherapp.data.remote.ApiDetails
import com.cherlan.weatherapp.ui.theme.PrimaryColorLight

@Composable
fun SmallWeatherWidget(weatherModel: WeatherModel) {

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(PrimaryColorLight)
            .width(100.dp)
            .height(150.dp)
            .padding(8.dp)
            .wrapContentWidth(Alignment.CenterHorizontally)
            .wrapContentHeight(Alignment.CenterVertically)

    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = weatherModel.dtTxt ?: "No date time available",
            color = Color(255, 255, 255)
        )

        AsyncImage(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            model = "${ApiDetails.baseUrlIcon}${weatherModel.weather?.get(0)?.icon}.png",
            contentDescription = null,
        )

        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "${weatherModel.main?.temp}",
                fontWeight = FontWeight.Bold,
                color = Color(255, 255, 255)
            )
            Text(
                text = "°C",
                fontWeight = FontWeight.Bold,
                color = Color(255, 255, 255)
            )
        }
    }
}


@Composable
fun SmallWeatherWidgets(weatherModels: List<WeatherModel?>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        items(weatherModels) {  weathearmodel ->
            SmallWeatherWidget(
                weatherModel = weathearmodel!!)
        }
    }

}