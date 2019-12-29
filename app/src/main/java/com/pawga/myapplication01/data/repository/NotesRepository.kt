package com.pawga.myapplication01.data.repository

import androidx.lifecycle.LiveData
import com.pawga.myapplication01.domain.model.Note

/**
 * Created by pawga on 29.12.19 16:45
 */

interface NotesRepository {
    fun insert(note: Note)

    fun insertAll(notes: List<Note>)

    fun noteById(id: Long): LiveData<Note>

    fun deleteAll()

    fun notes(requestedLoadSize: Int): List<Note>

    fun notesAfter(key: String, requestedLoadSize: Int): List<Note>
}