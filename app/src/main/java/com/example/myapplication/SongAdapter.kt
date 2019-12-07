package com.example.myapplication

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SongAdapter (
    private var dataSource: List<Song>,
    private val clickLambda: (Song) -> Unit
) : RecyclerView.Adapter<SongHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongHolder =
        SongHolder.create(parent, clickLambda)

    override fun getItemCount(): Int = dataSource.size

    override fun onBindViewHolder(holder: SongHolder, position: Int) =
        holder.bind(dataSource[position])
}
