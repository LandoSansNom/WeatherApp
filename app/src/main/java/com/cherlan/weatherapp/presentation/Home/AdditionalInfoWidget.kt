package com.cherlan.weatherapp.presentation.Home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun AdditionalInfoWidget(){
    Text(
        text = "Additional Info", fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color(18, 18, 18)
    )
}