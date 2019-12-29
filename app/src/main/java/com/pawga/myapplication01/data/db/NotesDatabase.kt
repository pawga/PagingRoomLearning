package com.pawga.myapplication01.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pawga.myapplication01.data.model.NoteEntity

/**
 * Created by pawga on 29.12.19 16:40
 */

@Database(
    entities = [NoteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun notesDao(): NotesDao

    companion object {

        @Volatile
        private var INSTANCE: NotesDatabase? = null

        fun getInstance(context: Context): NotesDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context): NotesDatabase =
            Room.databaseBuilder(context.applicationContext,
                NotesDatabase::class.java, "notesdb.db")
                .build()
    }
}

