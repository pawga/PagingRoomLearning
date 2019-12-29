package com.pawga.myapplication01.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.pawga.myapplication01.data.model.NoteEntity
import com.pawga.myapplication01.utils.ioThread
import timber.log.Timber

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

        private fun buildDatabase(context: Context): NotesDatabase {
            val database = Room.databaseBuilder(context.applicationContext,
                NotesDatabase::class.java, "notesdb.db")
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Timber.i("onCreate database")

                        fillInDb(context)
                    }
                })
                .build()

//            ioThread {
//                database.notesDao().insert(NoteEntity(1001, "Note"))
//            }

            return database
        }


        /**
         * fill database with list of notes so we can test pagination
         */
        private fun fillInDb(context: Context) {
            // inserts in Room are executed on the current thread, so we insert in the background
            ioThread {
                NotesDatabase.getInstance(context).notesDao().insertAll(
                    getData().map { NoteEntity(id = 0, noteText = it) }
                )
            }
        }
    }
}

private fun getData(): List<String> {
    return (1..100).map { "note" }
}
