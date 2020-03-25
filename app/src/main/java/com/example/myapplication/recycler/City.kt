package com.example.myapplication.recycler

import com.google.gson.annotations.SerializedName
import com.template.response.WeatherResponse

data class City (
    @SerializedName("message")
    var message: String,
    @SerializedName("accurate")
    var accurate: String,
    @SerializedName("cod")
    var cod: String,
    @SerializedName("count")
    var count: String,
    @SerializedName("list")
    var list: List<WeatherResponse>
)