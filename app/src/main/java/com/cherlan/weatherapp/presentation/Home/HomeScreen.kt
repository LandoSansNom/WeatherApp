package com.cherlan.weatherapp.presentation.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cherlan.weatherapp.R
import com.cherlan.weatherapp.data.model.ForeCast
import com.cherlan.weatherapp.data.remote.ApiDetails
import com.cherlan.weatherapp.presentation.navigation.BottomNavigationBar
import com.cherlan.weatherapp.ui.theme.PrimaryColorLight


@Composable
fun HomeScreen(foreCast: ForeCast){
    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        }
    ) {
        Box(modifier = Modifier
            .offset(x = 16.dp,y=16.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(PrimaryColorLight)
                    .height(200.dp)
                    .clickable { }
                    .padding(it),
            ) {

                CurrentWeather(foreCast = foreCast)
            }
        }
    }
}

@Composable
fun CurrentWeather(foreCast: ForeCast){

    Column {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .offset(x=16.dp,y=16.dp)
              //  .padding(start = 16.dp, top = 16.dp)

        ) {
            Image(painter = painterResource(id = R.drawable.location), contentDescription = "Map icon")
            Text(text = "${foreCast.city?.name ?: "City name not available"} , ${foreCast.city?.country ?: "Country name not available"}",
                color = Color(255,255,255)

            )
            Image(painter = painterResource(id = R.drawable.more),
                contentDescription = "Map icon",
                modifier = Modifier.padding(
                    start = 180.dp
                )
                )

        }

        Row(modifier = Modifier
            .padding(start = 16.dp,top = 16.dp)){
            Text(text = "${foreCast.list?.get(0)?.main?.temp}",
            fontSize = 40.sp,
            color = Color(255,255,255)
            )
            Text(text = "°", fontSize = 40.sp,
                color = Color(255,255,255)
            )

            AsyncImage(model = "${ApiDetails.baseUrlIcon}${foreCast.list?.get(0)?.weather?.get(0)?.icon}.png",
                contentDescription = null,

                )
        }

        Text(text = "${foreCast.list?.get(0)?.weather?.get(0)?.description}",
            color = Color(255,255,255))
    }
}








@Preview
@Composable
fun display(){
    //CurrentWeather()
}