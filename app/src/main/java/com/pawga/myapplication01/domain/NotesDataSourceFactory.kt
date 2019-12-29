package com.pawga.myapplication01.domain

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.pawga.myapplication01.domain.model.Note
import javax.inject.Inject

/**
 * Created by pawga on 29.12.19 22:01
 */

// @InjectConstructor альтернатива @Inject constructor

class NotesDataSourceFactory @Inject constructor(
    private val dataSource: NoteKeyedDataSource
) : DataSource.Factory<String, Note>() {

    private val notesLiveData = MutableLiveData<NoteKeyedDataSource>()

    override fun create(): DataSource<String, Note> {
        notesLiveData.postValue(dataSource)
        return dataSource
    }
}