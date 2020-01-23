package com.example.myapplication.db

import androidx.room.*

@Dao
interface NotesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: Note)

    @Query("SELECT * FROM note")
    suspend fun getNotes(): List<Note>

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteById(id: Int): Note?

    @Delete
    suspend fun deleteNotes(notes: Note)

    @Query("DELETE FROM note")
    suspend fun deleteAllNotes()

    @Query("UPDATE note SET title = :newTitle, description = :newDescription, dateNote = :newDateNote" +
            "latitude = :newLatitude, longitude = :newLongitude WHERE id = :id")
    suspend fun updateNote(id: Int, newTitle: String, newDescription: String, newDateNote: java.util.Date, newLatitude: String, newLongitude: String)
}
