package com.devsphere.aether.data.remote.dto.weather

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    @SerializedName("current") val current: CurrentBlock?,
    @SerializedName("hourly") val hourly: HourlyBlock?,
    @SerializedName("daily") val daily: DailyBlock?
)

data class CurrentBlock(
    @SerializedName("time") val time: String?,
    @SerializedName("temperature_2m") val temperature: Double?,
    @SerializedName("relative_humidity_2m") val humidity: Double?,
    @SerializedName("apparent_temperature") val apparentTemperature: Double?,
    @SerializedName("weather_code") val weatherCode: Int?,
    @SerializedName("wind_speed_10m") val windSpeed: Double?,
    @SerializedName("wind_direction_10m") val windDirection: Double?,
    @SerializedName("pressure_msl") val pressure: Double?,
    @SerializedName("visibility") val visibility: Double?
)

data class HourlyBlock(
    val time: List<String>?,
    @SerializedName("temperature_2m") val temperatures: List<Double>?,
    @SerializedName("relative_humidity_2m") val humidities: List<Double>?,
    @SerializedName("precipitation_probability") val precipitationProbabilities: List<Int>?,
    @SerializedName("weather_code") val weatherCodes: List<Int>?,
    @SerializedName("wind_speed_10m") val windSpeeds: List<Double>?,
    @SerializedName("visibility") val visibilities: List<Double>?
)

data class DailyBlock(
    val time: List<String>?,
    @SerializedName("temperature_2m_max") val tempMax: List<Double>?,
    @SerializedName("temperature_2m_min") val tempMin: List<Double>?,
    val sunrise: List<String>?,
    val sunset: List<String>?,
    @SerializedName("uv_index_max") val uvIndexMax: List<Double>?
)
