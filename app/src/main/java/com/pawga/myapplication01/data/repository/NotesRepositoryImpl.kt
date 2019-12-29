package com.pawga.myapplication01.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.pawga.myapplication01.data.DbNoteMapper
import com.pawga.myapplication01.data.db.NotesDao
import com.pawga.myapplication01.domain.model.Note
import toothpick.InjectConstructor

/**
 * Created by pawga on 29.12.19 16:48
 */

@InjectConstructor
class NotesRepositoryImpl(private val notesDao: NotesDao,
                          private val mapper: DbNoteMapper) : NotesRepository {

    override fun insert(note: Note) = notesDao.insert(mapper.toDb(note))

    override fun insertAll(notes: List<Note>) = notesDao.insertAll(notes.map { mapper.toDb(it) })

    override fun noteById(id: Long): LiveData<Note> =
        notesDao.noteById(id).map { mapper.fromDb(it) }

    override fun deleteAll() {
        notesDao.deleteAll()
    }

//    override fun allNotes(): DataSource.Factory<Int, Note> =
//        notesDao.allNotes().map { mapper.fromDb(it) }

    override fun allNotes(): LiveData<List<Note>> =
        notesDao.allNotes().map { it.map(mapper::fromDb) }
}