package com.devsphere.aether.data.remote.api

import com.devsphere.aether.data.remote.dto.weather.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast")
    suspend fun getWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current") current: String =
            "temperature_2m,relative_humidity_2m,apparent_temperature,weather_code,wind_speed_10m,wind_direction_10m,pressure_msl,visibility",
        @Query("hourly") hourly: String =
            "temperature_2m,relative_humidity_2m,precipitation_probability,weather_code,wind_speed_10m,visibility",
        @Query("daily") daily: String =
            "temperature_2m_max,temperature_2m_min,sunrise,sunset,uv_index_max",
        @Query("timezone") timezone: String = "auto"
    ): WeatherResponse
}