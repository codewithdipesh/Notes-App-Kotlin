package com.example.notesapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addNote(noteEntity : Note)

    //getting the important first
    @Query("select * from `note_table` order by note_isImportant desc,id asc")
    abstract fun getAllNotes():Flow<List<Note>>

    @Update
    abstract suspend fun updateNote(noteEntity: Note)

    @Delete
    abstract suspend fun deleteNote(noteEntity: Note)

    @Query("select * from note_table where id = :id")
    abstract  fun getNoteById(id:Long): Flow<Note>

}