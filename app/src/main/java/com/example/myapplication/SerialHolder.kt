package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_serial.*

class SerialHolder (
    override val containerView: View,
    private val clickLambda: (String, String, String, Int, Serial) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(serial: Serial) {
        tv_name_main.text = serial.name
        tv_duration_main.text = serial.duration
        tv_description_main.text = serial.description
        iv_main.setImageResource(serial.image)

        itemView.setOnClickListener {
            clickLambda(serial.name, serial.duration, serial.description, serial.image, serial)
        }
    }

    companion object {
        fun create(parent: ViewGroup, clickLambda: (String, String, String, Int, Serial) -> Unit) =
            SerialHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_serial, parent, false),
                clickLambda
            )
    }
}