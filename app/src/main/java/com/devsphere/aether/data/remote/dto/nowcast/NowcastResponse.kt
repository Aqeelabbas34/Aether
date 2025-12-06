package com.devsphere.aether.data.remote.dto.nowcast

import com.google.gson.annotations.SerializedName

data class NowcastResponse(
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    @SerializedName("minute") val minuteBlock: MinuteBlock?
)

data class MinuteBlock(
    val time: List<String>?,
    val precipitation: List<Double>?
)
