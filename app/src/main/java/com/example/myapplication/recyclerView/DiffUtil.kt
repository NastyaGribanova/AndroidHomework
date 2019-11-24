package com.example.myapplication.recyclerView

import androidx.recyclerview.widget.DiffUtil

class DiffUtil(private val oldLList: List<CompanionRecycler>, private val newList: List<CompanionRecycler>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldLList.size

    override fun getNewListSize(): Int = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldLList[oldItemPosition] == newList[newItemPosition]

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldLList[oldItemPosition] == newList[newItemPosition]
}
