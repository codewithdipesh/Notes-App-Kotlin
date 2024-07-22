package com.example.notesapp.repository

import com.example.notesapp.data.Note
import com.example.notesapp.data.NoteDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
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
    fun getNoteById(id:Long):Flow<Note> = dao.getNoteById(id)


    suspend fun deleteNote(note: Note){
        dao.deleteNote(note)
    }

}