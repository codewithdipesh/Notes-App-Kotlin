package com.example.notesapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
   @PrimaryKey(autoGenerate = true)
    val id : Long = 0L,
   @ColumnInfo("note_title")
    val title:String = "",
   @ColumnInfo("note_description")
    val description:String = "",
   @ColumnInfo("note_isImportant")
    val isImportant:Boolean = false
)