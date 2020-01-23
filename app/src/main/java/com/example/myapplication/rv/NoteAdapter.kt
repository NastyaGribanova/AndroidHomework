package com.example.myapplication.rv

import android.os.Bundle
import android.view.ViewGroup
import com.example.myapplication.du.DiffUtils
import com.example.myapplication.db.Note
import com.example.myapplication.du.Diff
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil

class NoteAdapter (
    private var dataSource: List<Note>,
    private val clickLambda: (Note) -> Unit
    ) : ListAdapter<Note, NoteHolder>(Diff){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder =
        NoteHolder.create(parent, clickLambda)

    override fun getItemCount(): Int = dataSource.size

    override fun onBindViewHolder(holder: NoteHolder, position: Int) =
        holder.bind(dataSource[position])

    override fun submitList(list: MutableList<Note>?) {
        super.submitList(list)
    }

    fun updateList(newList: List<Note>) {
        DiffUtil.calculateDiff(DiffUtils(this.dataSource, newList), false)
            .dispatchUpdatesTo(this)
        this.dataSource = newList
    }

    override fun onBindViewHolder(
        holder: NoteHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty())
            super.onBindViewHolder(holder, position, payloads)
        else {
            val bundle = payloads[0] as? Bundle
            if (bundle != null) {
                holder.update(bundle)
            }
        }
    }
}
