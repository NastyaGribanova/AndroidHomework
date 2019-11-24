package com.example.myapplication.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_companion.*

class CompanionHolder (
    override val containerView: View,
    private val clickLambda: (CompanionRecycler) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(companion: CompanionRecycler) {
        tv_name.text = companion.name
        tv_description.text = companion.description

        itemView.setOnClickListener {
            clickLambda(companion)
        }
    }

    companion object {
        fun create(parent: ViewGroup, clickLambda: (CompanionRecycler) -> Unit) =
            CompanionHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_companion, parent, false),
                clickLambda
            )
    }
}
