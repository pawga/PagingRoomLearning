package com.pawga.myapplication01.presentation.main

import androidx.recyclerview.widget.DiffUtil
import com.pawga.myapplication01.domain.model.Note

/**
 * Created by pawga on 29.12.19 19:06
 */


class NoteDiffCallback(private val old: List<Note>,
                       private val new: List<Note>) : DiffUtil.Callback() {
    override fun getOldListSize() = old.size

    override fun getNewListSize() = new.size

    override fun areItemsTheSame(oldIndex: Int, newIndex: Int): Boolean {
        return old[oldIndex].text == new[newIndex].text
    }

    override fun areContentsTheSame(oldIndex: Int, newIndex: Int): Boolean {
        return old[oldIndex] == new[newIndex]
    }
}