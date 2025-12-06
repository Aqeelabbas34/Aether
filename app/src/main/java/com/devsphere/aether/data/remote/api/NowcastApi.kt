package com.devsphere.aether.data.remote.api

import com.devsphere.aether.data.remote.dto.nowcast.NowcastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NowcastApi {

    @GET("nowcast")
    suspend fun getNowcast(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("minute") minute: String = "precipitation",
        @Query("past_minutes") pastMinutes: Int = 0,
        @Query("forecast_minutes") forecastMinutes: Int = 120,
        @Query("timezone") timezone: String = "auto"
    ): NowcastResponse
}
