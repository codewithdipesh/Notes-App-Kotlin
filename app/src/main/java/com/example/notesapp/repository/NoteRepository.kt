package com.example.notesapp.repository

import com.example.notesapp.data.Note
import com.example.notesapp.data.NoteDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class NoteRepository @Inject constructor(
    private val dao: NoteDao
){
    suspend fun addNote(note: Note){
        dao.addNote(note)
    }
    fun getAllNotes(): Flow<List<Note>> = dao.getAllNotes()

    suspend fun updateNote(note: Note) {
       dao.updateNote(note)
    }

    suspend fun updateIsImportant(id:Long,isImportant : Boolean){
        dao.updateIsImportant(id,isImportant )
    }

    suspend fun deleteNote(note: Note){
        dao.deleteNote(note)
    }
    fun getNoteById(id:Long):Flow<Note> = dao.getNoteById(id)
}