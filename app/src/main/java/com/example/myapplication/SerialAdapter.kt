package com.example.myapplication

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SerialAdapter (
    private var dataSource: List<Serial>,
    private val clickLambda: (String, String, String, Int, Serial) -> Unit
) : RecyclerView.Adapter<SerialHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SerialHolder =
        SerialHolder.create(parent, clickLambda)

    override fun getItemCount(): Int = dataSource.size

    override fun onBindViewHolder(holder: SerialHolder, position: Int) =
        holder.bind(dataSource[position])
}