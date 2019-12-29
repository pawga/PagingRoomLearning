package com.pawga.myapplication01.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pawga.myapplication01.ApplicationScope
import com.pawga.myapplication01.data.DbNoteMapper
import com.pawga.myapplication01.data.repository.NotesRepository
import com.pawga.myapplication01.domain.model.Note
import toothpick.ktp.KTP
import toothpick.ktp.delegate.inject


private const val PAGE_SIZE = 10

class MainViewModel : ViewModel() {

    //val appContext: Context by inject()
    val notesRepository: NotesRepository by inject()

    lateinit var notes: LiveData<List<Note>>

    private val mapper = DbNoteMapper()

    init {
        injectDependencies()
        loadData()
    }

    fun loadData() {
        notes = notesRepository.allNotes()
    }

    fun injectDependencies() {
        KTP.openScopes(ApplicationScope::class.java)
            .inject(this)
    }
}
