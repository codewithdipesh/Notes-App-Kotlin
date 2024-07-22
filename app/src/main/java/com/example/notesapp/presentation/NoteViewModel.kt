package com.example.notesapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.data.Note
import com.example.notesapp.repository.NoteRepository
import com.example.notesapp.utils.toArgbInt
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private  val repository: NoteRepository
): ViewModel() {

    var titleState by mutableStateOf("")
    var descriptionState by mutableStateOf("")
    var colorState by mutableStateOf(Color.Gray.toArgbInt())
    var isImportantState by mutableStateOf(false)


    val allNotes:StateFlow<List<Note>> = repository.getAllNotes()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun onNoteTitleChanged(newtitle : String){
        titleState = newtitle
    }
    fun onNoteDescriptionChanged(newdescription : String){
        descriptionState = newdescription
    }

    fun onColorStateChanged(newcolor : Int){
        colorState = newcolor
    }

    fun onImportantStateChanged(newstate : Boolean){
        isImportantState = newstate
    }

    fun addNote(note: Note){
        viewModelScope.launch {
            repository.addNote(note)
        }
    }
    fun updateNote(note: Note){
        viewModelScope.launch {
            repository.updateNote(note)
        }
    }

    fun deleteNote(note: Note){
        viewModelScope.launch {
            repository.deleteNote(note)
        }
    }


    fun getNoteById(id: Long):Flow<Note>{
     return repository.getNoteById(id)
    }



}