package com.pawga.myapplication01.data

import com.pawga.myapplication01.data.model.NoteEntity
import com.pawga.myapplication01.domain.model.Note

/**
 * Created by pawga on 29.12.19 16:32
 */

//@InjectConstructor

class DbNoteMapper {
    fun fromDb(from: NoteEntity) = Note(from.id, from.noteText)
    fun toDb(from: Note) = NoteEntity(from.id, from.text)
}