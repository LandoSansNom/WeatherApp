package com.cherlan.weatherapp.domain

import com.cherlan.weatherapp.data.model.ForeCast

sealed class Result {
    data class Success(val data: ForeCast): Result()
    data class Failure(val error: String): Result()
    object Loading: Result()
}