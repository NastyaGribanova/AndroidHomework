package com.example.myapplication.recycler

import androidx.recyclerview.widget.RecyclerView
import com.template.response.WeatherResponse
import android.view.ViewGroup

class CityAdapter(
    var weatherList: List<WeatherResponse>,
    private val clickLambda: (WeatherResponse) -> Unit
) : RecyclerView.Adapter<CityHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder =
        CityHolder.create(
            parent,
            clickLambda
        )

    override fun getItemCount(): Int = weatherList.size

    override fun onBindViewHolder(holder: CityHolder, position: Int) =
        holder.bind(weatherList[position])
}