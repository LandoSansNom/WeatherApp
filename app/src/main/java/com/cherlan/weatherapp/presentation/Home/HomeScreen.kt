package com.cherlan.weatherapp.presentation.Home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cherlan.weatherapp.data.model.ForeCast
import com.cherlan.weatherapp.data.model.WeatherModel
import com.cherlan.weatherapp.presentation.navigation.BottomNavigationBar


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(foreCast: ForeCast) {
    var WeatherModels by remember { mutableStateOf(foreCast.list?.filter { it?.dtTxt?.startsWith(foreCast.list.get(0)?.dtTxt?.substring(0,10) ?: "") ?: false  }) }

    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        }
    ) {
        Box(
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp, end = 16.dp)
        ) {

            Column(
                modifier = Modifier
                    .clickable { }
                    .padding(it),
            ) {

                CurrentWeatherWidget(foreCast = foreCast)
                Spacer(modifier = Modifier.height(25.dp))
                DateItems(weatherModels = foreCast.list!!){date->
                    WeatherModels = foreCast.list.filter { it?.dtTxt?.startsWith(date) ?: false }
                }
                Spacer(modifier = Modifier.height(25.dp))
                SmallWeatherWidgets(weatherModels = WeatherModels!!)
                Spacer(modifier = Modifier.height(25.dp))
                AdditionalInfoWidget()

            }
        }
    }
}



