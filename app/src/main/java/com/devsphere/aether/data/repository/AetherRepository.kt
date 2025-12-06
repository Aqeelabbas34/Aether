package com.devsphere.aether.data.repository

import com.devsphere.aether.data.remote.api.AirQualityApi
import com.devsphere.aether.data.remote.api.GeocodingApi
import com.devsphere.aether.data.remote.api.NowcastApi
import com.devsphere.aether.data.remote.api.WeatherApi
import com.devsphere.aether.data.remote.dto.air.AirQualityResponse
import com.devsphere.aether.data.remote.dto.geocoding.GeocodingResponse
import com.devsphere.aether.data.remote.dto.nowcast.NowcastResponse
import com.devsphere.aether.data.remote.dto.weather.WeatherResponse
import com.devsphere.aether.network.ApiHandler
import com.devsphere.aether.network.ApiResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AetherRepository @Inject constructor(
    private val weatherApi: WeatherApi,
    private val nowcastApi: NowcastApi,
    private val airQualityApi: AirQualityApi,
    private val geocodingApi: GeocodingApi
) {

    suspend fun getWeather(
        latitude: Double,
        longitude: Double,
        timezone: String = "auto"
    ): ApiResult<WeatherResponse> =
        ApiHandler.execute {
            weatherApi.getWeather(
                latitude = latitude,
                longitude = longitude,
                timezone = timezone
            )
        }

    suspend fun getNowcast(
        latitude: Double,
        longitude: Double,
        timezone: String = "auto"
    ): ApiResult<NowcastResponse> =
        ApiHandler.execute {
            nowcastApi.getNowcast(
                latitude = latitude,
                longitude = longitude,
                timezone = timezone
            )
        }

    suspend fun getAirQuality(
        latitude: Double,
        longitude: Double,
        timezone: String = "auto"
    ): ApiResult<AirQualityResponse> =
        ApiHandler.execute {
            airQualityApi.getAirQuality(
                latitude = latitude,
                longitude = longitude,
                timezone = timezone
            )
        }

    suspend fun searchLocations(
        name: String,
        count: Int = 10,
        language: String = "en"
    ): ApiResult<GeocodingResponse> =
        ApiHandler.execute {
            geocodingApi.searchLocations(
                name = name,
                count = count,
                language = language
            )
        }

    suspend fun reverseGeocode(
        latitude: Double,
        longitude: Double,
        language: String = "en"
    ): ApiResult<GeocodingResponse> =
        ApiHandler.execute {
            geocodingApi.reverseGeocode(
                latitude = latitude,
                longitude = longitude,
                language = language
            )
        }
}
