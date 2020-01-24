package com.example.myapplication.rv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.db.NotesContract
import kotlinx.android.extensions.LayoutContainer
import com.example.myapplication.db.Note
import kotlinx.android.synthetic.main.item_note.view.*

class NoteHolder (
    override val containerView: View,
    private val clickLambda: (Note) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(note: Note) {
        containerView.tv_title.text = note.title
        containerView.tv_description.text = note.description
        containerView.tv_date.text = note.dateNote.toString()
        containerView.tv_longitude.text = note.longitude
        containerView.tv_latitude.text = note.latitude
        itemView.setOnClickListener {
            clickLambda(note)
        }
    }

    fun update(bundle: Bundle) {
        containerView.tv_title.text = bundle.getString(NotesContract.DATA.ARG_TITLE) ?: "NULL"
        containerView.tv_description.text = bundle.getString(NotesContract.DATA.ARG_DESCRIPTION) ?: "NULL"
        containerView.tv_longitude.text = bundle.getString(NotesContract.DATA.ARG_LONGITUDE) ?: "NULL"
        containerView.tv_latitude.text = bundle.getString(NotesContract.DATA.ARG_LATITUDE) ?: "NULL"
    }

    companion object {
        fun create(parent: ViewGroup, clickLambda: (Note) -> Unit) =
            NoteHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false),
                clickLambda
            )
    }
}
