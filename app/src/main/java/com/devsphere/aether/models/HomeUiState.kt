package com.devsphere.aether.models

import com.devsphere.aether.data.remote.dto.air.AirQualityResponse
import com.devsphere.aether.data.remote.dto.nowcast.NowcastResponse
import com.devsphere.aether.data.remote.dto.weather.WeatherResponse

data class HomeUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val weather: WeatherResponse? = null,
    val airQuality: AirQualityResponse? = null,
    val nowcast: NowcastResponse? = null
)
