package com.devsphere.aether.data.remote.dto.geocoding

import com.google.gson.annotations.SerializedName

data class GeocodingResponse(
    val results: List<GeocodingResult>?
)

data class GeocodingResult(
    val id: Int?,
    val name: String?,
    val latitude: Double?,
    val longitude: Double?,
    val country: String?,
    @SerializedName("admin1") val adminRegion: String?,
    val timezone: String?
)
