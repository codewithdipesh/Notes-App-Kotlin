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

    @Query("select * from `note_table`")
    abstract fun getAllNotes():Flow<List<Note>>

    @Update
    abstract suspend fun updateNote(noteEntity: Note)

    @Query("update `note_table` set note_isImportant = :isImportant where id = :id")
    abstract suspend fun updateIsImportant(id: Long , isImportant:Boolean)

    @Delete
    abstract suspend fun deleteNote(noteEntity: Note)

    @Query("select * from note_table where id = :id")
    abstract  fun getNoteById(id:Long): Flow<Note>

}