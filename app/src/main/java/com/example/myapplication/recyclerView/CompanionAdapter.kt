package com.example.myapplication.recyclerView

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.*
import androidx.recyclerview.widget.ListAdapter

class CompanionAdapter(
    private var dataSource: ArrayList<CompanionRecycler>,
    private val clickLambda: (CompanionRecycler) -> Unit
) : ListAdapter<CompanionRecycler, CompanionHolder>(Diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanionHolder =
        CompanionHolder.create(parent, clickLambda)

    override fun getItemCount(): Int = dataSource.size

    override fun onBindViewHolder(holder: CompanionHolder, position: Int) =
        holder.bind(dataSource[position])

    fun updateList(newList: ArrayList<CompanionRecycler>) {
        calculateDiff(
            DiffUtil(this.dataSource, newList),
            true
        )
            .dispatchUpdatesTo(this)
        this.dataSource.clear()
        this.dataSource.addAll(newList)
    }
}
