package com.cherlan.weatherapp.presentation.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cherlan.weatherapp.R
import com.cherlan.weatherapp.data.model.ForeCast
import com.cherlan.weatherapp.data.remote.ApiDetails
import com.cherlan.weatherapp.ui.theme.PrimaryColorLight

@Composable
fun CurrentWeatherWidget(foreCast: ForeCast) {

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(PrimaryColorLight)
            .fillMaxWidth()
            .height(230.dp)

    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp)
                .fillMaxWidth()

        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.location),
                    contentDescription = "Map icon"
                )
                Text(
                    text = "${foreCast.city?.name ?: "City name not available"} , ${foreCast.city?.country ?: "Country name not available"}",
                    color = Color(255, 255, 255),
                    fontSize = 16.sp

                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = R.drawable.more),
                contentDescription = "See more",
                modifier = Modifier.padding(end = 16.dp)
            )

        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(start = 16.dp, top = 20.dp)
                .fillMaxWidth()
        ) {
            Row {
                Text(
                    text = "${foreCast.list?.get(0)?.main?.temp}",
                    fontSize = 60.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(255, 255, 255)
                )
                Text(
                    text = "°", fontSize = 60.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(255, 255, 255)
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            AsyncImage(
                model = "${ApiDetails.baseUrlIcon}${foreCast.list?.get(0)?.weather?.get(0)?.icon}.png",
                contentDescription = null,
                modifier = Modifier.padding(end = 85.dp, top = 20.dp)
            )
        }

        Text(text = "Celcius",
            color = Color(255,255,255),
            fontSize = 20.sp,
            modifier = Modifier.padding(
                start = 16.dp,
                top = 5.dp
            )

        )

        Spacer(modifier = Modifier.weight(1f)) // Add spacer to push the text almost to the bottom

        Text(
            fontSize = 16.sp,
            text = "${foreCast.list?.get(0)?.weather?.get(0)?.description}",
            color = Color(255, 255, 255),
            modifier = Modifier.padding(start = 16.dp,bottom = 16.dp)
        )
    }
}