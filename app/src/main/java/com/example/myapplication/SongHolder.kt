package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_song.*


class SongHolder (
    override val containerView: View,
    private val clickLambda: (Song) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(song: Song) {

        tv_name_item_song.text = song.name
        tv_description_item_song.text = song.band + " " + song.album
        iv_song.setImageResource(song.cover)

        itemView.setOnClickListener {
            clickLambda(song)
        }
    }

    companion object {
        fun create(parent: ViewGroup, clickLambda: (Song) -> Unit) =
            SongHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false),
                clickLambda
            )
    }
}
