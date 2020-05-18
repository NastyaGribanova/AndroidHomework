package com.template.response
import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("deg")
    var deg: Int,
    @SerializedName("gust")
    var gust: Int,
    @SerializedName("speed")
    var speed: Double
)