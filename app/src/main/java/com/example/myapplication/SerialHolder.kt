package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_serial.*

class SerialHolder (
    override val containerView: View,
    private val clickLambda: (Serial) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(serial: Serial) {
        tv_name_main.text = serial.name
        tv_duration_main.text = serial.duration
        tv_description_main.text = serial.description
        iv_main.setImageResource(serial.image)

        itemView.setOnClickListener {
            clickLambda(serial)
        }
    }

    companion object {
        fun create(parent: ViewGroup, clickLambda: (Serial) -> Unit) =
            SerialHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_serial, parent, false),
                clickLambda
            )
    }
}
