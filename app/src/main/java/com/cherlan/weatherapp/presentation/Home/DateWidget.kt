package com.cherlan.weatherapp.presentation.Home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cherlan.weatherapp.data.model.WeatherModel
import com.cherlan.weatherapp.presentation.common.dateToString
import com.cherlan.weatherapp.presentation.common.formatDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateItem(weatherModel: WeatherModel, onDateClicked: (String) -> Unit) {
    val date = weatherModel.dtTxt?.substring(0, 10)
    Text(
        text = dateToString(formatDate(weatherModel.dtTxt)) ?: "No date time available",
        color = Color(184, 184, 184),
        modifier = Modifier.clickable {
            onDateClicked(date!!)
        }
    )
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateItems(weatherModels: List<WeatherModel?>, onDateClicked: (String) -> Unit) {
    val uniqueDates = weatherModels.filterNotNull().map { it.dtTxt?.substring(0, 10) }.distinct()

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        items(uniqueDates) { uniquedate ->
            val weatherModelForDate =
                weatherModels.firstOrNull { it?.dtTxt?.startsWith(uniquedate!!) ?: false }
            if (weatherModelForDate != null) {
                DateItem(weatherModelForDate) { date ->
                    onDateClicked(date)
//                    val filteredWeatherModels = weatherModels.filter { weathermodel ->
//                        weathermodel?.dtTxt?.startsWith(date) ?: false
//                    }
//                    SmallWeatherWidgets(weatherModels = filteredWeatherModels)
                }
            }

        }
    }

}
