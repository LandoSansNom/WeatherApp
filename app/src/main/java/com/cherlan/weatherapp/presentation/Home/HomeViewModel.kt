package com.cherlan.weatherapp.presentation.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cherlan.weatherapp.data.repository.Repository
import com.cherlan.weatherapp.domain.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel(){
    private val _foreCastState = MutableStateFlow<Result>(Result.Loading)
    val foreCastState = _foreCastState.asStateFlow()


    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getWeatherForeCast(524901, "metric").collect{
                _foreCastState.value = it
            }
        }
    }
}