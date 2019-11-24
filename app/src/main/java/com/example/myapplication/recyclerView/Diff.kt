package com.example.myapplication.recyclerView

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil

object Diff : DiffUtil.ItemCallback<CompanionRecycler>() {

    override fun areItemsTheSame(oldItem: CompanionRecycler, newItem: CompanionRecycler): Boolean =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: CompanionRecycler, newItem: CompanionRecycler): Boolean =
        oldItem.description == newItem.description

    override fun getChangePayload(oldItem: CompanionRecycler, newItem: CompanionRecycler): Any? {
        val diffBundle = Bundle()
        if (oldItem.name != newItem.name) {
            diffBundle.putString("name", newItem.name)
        }
        if (oldItem.description != newItem.description) {
            diffBundle.putString("description", newItem.description)
        }
        return if (diffBundle.isEmpty) null else diffBundle
    }

}
