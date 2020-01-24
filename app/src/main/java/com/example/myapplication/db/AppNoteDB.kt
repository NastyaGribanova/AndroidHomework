package com.example.myapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class AppNoteDB : RoomDatabase() {
    abstract fun notesDao(): NotesDAO

    companion object {

        private const val DATABASE_NAME = "noteDB"

        @Volatile
        private var instance: AppNoteDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppNoteDB::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }
}
