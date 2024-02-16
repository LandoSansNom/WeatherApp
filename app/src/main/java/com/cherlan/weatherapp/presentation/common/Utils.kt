package com.cherlan.weatherapp.presentation.common

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
fun formatDate(input: String?): LocalDate {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    return LocalDate.parse(input, formatter)
}


@RequiresApi(Build.VERSION_CODES.O)
fun dateToString(input: LocalDate) : String{
    val day = input.dayOfWeek.toString().lowercase().CapitalizeFirstLetter()
    val month = input.month.toString().lowercase().CapitalizeFirstLetter()
    return "$day, ${input.dayOfMonth} $month ${input.year}"
}




@RequiresApi(Build.VERSION_CODES.O)
fun main(){
    println(formatDate("2024-02-13 03:00:00"))
}

fun String.CapitalizeFirstLetter(): String{
    return if(isNotEmpty()){
        this.substring(0, 1).uppercase() + this.substring(1)
    }else{
        this
    }
}