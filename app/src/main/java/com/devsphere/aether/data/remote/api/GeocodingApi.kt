package com.devsphere.aether.data.remote.api

import com.devsphere.aether.data.remote.dto.geocoding.GeocodingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApi {

    @GET("search")
    suspend fun searchLocations(
        @Query("name") name: String,
        @Query("count") count: Int = 10,
        @Query("language") language: String = "en"
    ): GeocodingResponse

    @GET("reverse")
    suspend fun reverseGeocode(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("language") language: String = "en"
    ): GeocodingResponse
}
