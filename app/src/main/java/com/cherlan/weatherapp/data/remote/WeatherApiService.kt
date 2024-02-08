package com.cherlan.weatherapp.data.remote

import com.cherlan.weatherapp.data.model.ForeCast
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService{
    @GET(ApiDetails.foreCastEndpoint)
    suspend fun getWeatherForeCast(
        @Query("id") id: Int,
        @Query("appid") appid: String
    ) : Response<ForeCast>
}