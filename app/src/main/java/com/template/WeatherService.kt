package com.template

import com.template.response.WeatherResponse
import com.example.myapplication.recycler.City
import retrofit2.http.GET
import retrofit2.http.Query

//https://api.openweathermap.org/data/2.5/
// weather?q=Kazan&appid=bfc55a5cb0cffabb710728ad8a3a44af
interface WeatherService {
    @GET("weather")
    suspend fun weatherByName(@Query("q") name: String) : WeatherResponse

    @GET("weather")
    suspend fun weatherById(@Query("id") id: Int): WeatherResponse

    @GET("find")
    suspend fun weatherByLatLon(
        @Query("lat") lat: Double, @Query("lon") lon: Double,
        @Query("cnt") count: Int
    ): City
}