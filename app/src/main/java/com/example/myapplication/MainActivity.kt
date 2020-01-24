package com.example.myapplication

import android.content.Intent
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.db.AppNoteDB
import com.example.myapplication.db.Note
import com.example.myapplication.rv.NoteAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), CoroutineScope  by MainScope() {

    private lateinit var db: AppNoteDB
    private var noteAdapter: NoteAdapter? = null
    private lateinit var noteLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = AppNoteDB(this)
        launch {
            noteLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            rv_notes.layoutManager = noteLayoutManager
            rv_notes.adapter = noteAdapter
        }
        initListeners()
    }

    fun onClick(view: View) {
        val intent = Intent(this, NoteFragment::class.java )
        startActivity(intent)
    }

    private fun initListeners() {
        delete_fab.setOnClickListener {
            launch {
                deleteAllNotes()
                noteAdapter?.updateList(getListNotes())
            }
        }
    }

    private fun setRecyclerViewItemTouchListener() {
        val itemTouchCallback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                viewHolder1: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
                launch {
                    val position = viewHolder.adapterPosition
                    deleteNote(getListNotes()[position])
                }
            }
        }
        val itemTouchHelper = ItemTouchHelper(itemTouchCallback)
        rv_notes.addItemDecoration(itemTouchHelper)
        itemTouchHelper.attachToRecyclerView(rv_notes as RecyclerView?)
    }

    private fun deleteNote(note: Note) {
        launch {
            db.notesDao().deleteNotes(note)
            noteAdapter?.updateList(getListNotes())
        }
    }

    private fun deleteAllNotes() {
        launch {
            db.notesDao().deleteAllNotes()
            noteAdapter?.updateList(getListNotes())
        }
    }

    private suspend fun getListNotes(): List<Note> = db.notesDao().getNotes()

    private fun setNotesFragment(action: String, id: Int, title: String, description: String) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, NoteFragment.newInstance(action, id, title, description))
            commit()

        }
    }

    fun changeNotes(action: String, note: Note) {
        setNotesFragment(action, note.id, note.title ?: "", note.description ?: "")
    }
}
