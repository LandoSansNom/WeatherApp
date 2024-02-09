package com.cherlan.weatherapp.data.repository

import com.cherlan.weatherapp.domain.Result
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getWeatherForeCast(id: Int, units: String = "standard") : Flow<Result>
}