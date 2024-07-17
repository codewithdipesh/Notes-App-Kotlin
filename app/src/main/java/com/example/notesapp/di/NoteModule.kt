package com.example.notesapp.di

import android.content.Context
import androidx.room.Room
import com.example.notesapp.data.NoteDao
import com.example.notesapp.data.NoteDatabase
import com.example.notesapp.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(@ApplicationContext context: Context): NoteDatabase{
        return Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            "note_database"

        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(noteDatabase: NoteDatabase):NoteDao{
        return noteDatabase.noteDao()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(noteDao: NoteDao):NoteRepository{
        return NoteRepository(noteDao)
    }

}