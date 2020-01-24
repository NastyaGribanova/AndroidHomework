package com.example.myapplication.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "note")
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "title")
    var title: String?,
    @ColumnInfo(name = "description")
    var description: String?,
    @ColumnInfo(name = "dateNote")
    var dateNote: Date,
    @ColumnInfo(name = "latitude")
    var latitude: String?,
    @ColumnInfo(name = "longitude")
    var longitude: String?
)
