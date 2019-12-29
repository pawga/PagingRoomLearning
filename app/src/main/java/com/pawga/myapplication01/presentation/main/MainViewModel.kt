package com.pawga.myapplication01.presentation.main

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pawga.myapplication01.ApplicationScope
import com.pawga.myapplication01.data.repository.NotesRepository
import com.pawga.myapplication01.domain.model.Note
import com.pawga.myapplication01.utils.ioThread
import toothpick.ktp.KTP
import toothpick.ktp.delegate.inject

private const val PAGE_SIZE = 10

class MainViewModel : ViewModel() {

    val appContext: Context by inject()
    val notesRepository: NotesRepository by inject()

    lateinit var notes: LiveData<List<Note>>

    init {
        injectDependencies()
        loadData()
    }

    private fun loadData() {
        fillInDb(appContext)
        notes = notesRepository.allNotes()
    }

    private fun injectDependencies() {
        KTP.openScopes(ApplicationScope::class.java)
            .inject(this)
    }

    private fun fillInDb(context: Context) {
        ioThread {
            notesRepository.deleteAll()
            notesRepository.insertAll(
                getData().map { Note(id = 0, text = it) }
            )
        }
    }

    private fun getData(): List<String> {
        return (1..64).map { "note" }
    }
}
