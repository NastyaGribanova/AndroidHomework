package com.example.myapplication.du

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.db.Note
import com.example.myapplication.db.NotesContract

object Diff : DiffUtil.ItemCallback<Note>() {

    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.description == newItem.description
    }

    override fun getChangePayload(oldItem: Note, newItem: Note): Any? {
        val diffBundle = Bundle()
        if (oldItem.title != newItem.title) {
            diffBundle.putString(NotesContract.DATA.ARG_TITLE, newItem.title)
        }
        if (oldItem.description != newItem.description) {
            diffBundle.putString(NotesContract.DATA.ARG_DESCRIPTION, newItem.description)
        }
        if (oldItem.latitude != newItem.latitude) {
            diffBundle.putString(NotesContract.DATA.ARG_LATITUDE, newItem.latitude)
        }
        if (oldItem.longitude != newItem.longitude) {
            diffBundle.putString(NotesContract.DATA.ARG_LONGITUDE, newItem.longitude)
        }
        return if (diffBundle.isEmpty) null
        else diffBundle
    }

}
