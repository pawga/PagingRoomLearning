package com.pawga.myapplication01.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pawga.myapplication01.data.model.NoteEntity

/**
 * Created by pawga on 29.12.19 16:37
 */


@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: NoteEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(note: List<NoteEntity>)

    @Query("DELETE FROM notes")
    fun deleteAll()

    @Query("SELECT * FROM notes WHERE id = :id")
    fun noteById(id: Long): LiveData<NoteEntity>

    @Query("SELECT * FROM notes ORDER BY note_text ASC limit :requestedLoadSize")
    fun notes(requestedLoadSize: Int): List<NoteEntity>

    @Query("SELECT * FROM notes WHERE note_text > :key ORDER BY note_text ASC limit :requestedLoadSize")
    fun notesAfter(key: String, requestedLoadSize: Int): List<NoteEntity>
}