package com.cherlan.weatherapp.data.repository

import com.cherlan.weatherapp.data.remote.WeatherApiService
import com.cherlan.weatherapp.domain.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val weatherApiService: WeatherApiService) : Repository {
    override suspend fun getWeatherForeCast(id: Int, units: String): Flow<Result> {
        return flow {
            emit(Result.Loading)
            val response = weatherApiService.getWeatherForeCast(id,units)

            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Result.Success(it))
                } ?: emit(Result.Failure(response.message()))
            } else {
                emit(Result.Failure(response.message()))
            }
        }.catch {
            emit(Result.Failure(it.message.toString()))
        }
    }

}