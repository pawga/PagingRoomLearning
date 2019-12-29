package com.pawga.myapplication01

import android.app.Application
import android.content.Context
import com.pawga.myapplication01.data.DbNoteMapper
import com.pawga.myapplication01.data.db.NotesDatabase
import com.pawga.myapplication01.data.repository.NotesRepository
import com.pawga.myapplication01.data.repository.NotesRepositoryImpl
import toothpick.config.Module

/**
 * Created by pawga on 29.12.19 17:12
 */

class AppModule(val application: Application) : Module() {

    init {
        val context = application.applicationContext
        bind(Application::class.java).toInstance(application)
        bind(Context::class.java).toInstance(context)
        bind(NotesRepository::class.java)
            .toInstance(
                NotesRepositoryImpl(
                NotesDatabase.getInstance(context).notesDao(),
                DbNoteMapper()
                )
            )
    }
}