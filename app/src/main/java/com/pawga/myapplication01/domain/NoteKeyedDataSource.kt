package com.pawga.myapplication01.domain

import androidx.paging.ItemKeyedDataSource
import com.pawga.myapplication01.data.repository.NotesRepository
import com.pawga.myapplication01.domain.model.Note
import toothpick.InjectConstructor

/**
 * Created by pawga on 29.12.19 21:50
 */

@InjectConstructor
class NoteKeyedDataSource(
    private val notesRepo: NotesRepository
) : ItemKeyedDataSource<String, Note>() {

    override fun loadInitial(params: LoadInitialParams<String>, callback: LoadInitialCallback<Note>) {
        val items = notesRepo.notes(requestedLoadSize = params.requestedLoadSize)
        callback.onResult(items)
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<Note>) {
        val items = notesRepo.notesAfter(key = params.key, requestedLoadSize = params.requestedLoadSize)
        callback.onResult(items)
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<Note>) {
    }

    override fun getKey(item: Note) = item.text
}