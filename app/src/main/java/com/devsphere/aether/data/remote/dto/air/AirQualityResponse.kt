package com.devsphere.aether.data.remote.dto.air

import com.google.gson.annotations.SerializedName

data class AirQualityResponse(
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    @SerializedName("hourly") val hourly: AirQualityHourly?
)

data class AirQualityHourly(
    val time: List<String>?,
    val pm10: List<Double>?,
    @SerializedName("pm2_5") val pm25: List<Double>?,
    @SerializedName("nitrogen_dioxide") val no2: List<Double>?,
    @SerializedName("sulphur_dioxide") val so2: List<Double>?,
    val ozone: List<Double>?,
    @SerializedName("carbon_monoxide") val co: List<Double>?,
    @SerializedName("european_aqi") val eAqi: List<Int>?
)
