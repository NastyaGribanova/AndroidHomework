package com.example.myapplication

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes

data class Song (
    var name: String,
    var band: String,
    var album: String,
    @DrawableRes
    var cover: Int,
    @RawRes
    var audio: Int
    )
