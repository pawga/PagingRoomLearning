package com.pawga.myapplication01.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.pawga.myapplication01.R
import com.pawga.myapplication01.domain.model.Note
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private val clickListener: ClickListener = this::onNoteClicked

    private val recyclerViewAdapter = NoteAdapter(clickListener)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupRecyclerView()
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private fun onNoteClicked(note: Note) {
//        val navDirections = actionNotesToNoteDetail(note.id)
//        view?.let {
//            Navigation.findNavController(it).navigate(navDirections)
//        }
    }

    private fun setupRecyclerView() {
        notesRecyclerView.layoutManager = LinearLayoutManager(this.context)
        notesRecyclerView.adapter = recyclerViewAdapter

        //debug
        recyclerViewAdapter.updateNotes(listOf(
            Note(1, "Note"),
            Note(2, "Note"),
            Note(3, "Note"),
            Note(4, "Note"),
            Note(5, "Note"),
            Note(6, "Note"),
            Note(7, "Note"),
            Note(8, "Note")
        ))
    }

}
