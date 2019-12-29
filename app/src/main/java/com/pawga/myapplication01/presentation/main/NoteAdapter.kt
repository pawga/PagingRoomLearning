package com.pawga.myapplication01.presentation.main

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.pawga.myapplication01.domain.model.Note

/**
 * Created by pawga on 29.12.19 18:01
 */

typealias ClickListener = (Note) -> Unit

class NoteAdapter(
    private val clickListener: ClickListener
) : PagedListAdapter<Note, NoteViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        val note = getItem(position)

        with(holder) {
            bindTo(note)
            note?.let {
                itemView.setOnClickListener {
                    clickListener(note)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder =
        NoteViewHolder(parent)

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Note>() {
            override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean =
                oldItem == newItem
        }
    }
}