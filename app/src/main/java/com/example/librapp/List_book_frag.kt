package com.example.librapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

class List_book_frag : Fragment() {

    val authors = arrayListOf<String>(
        "Virat Kohli", "Rohit Sharma", "Steve Smith",
        "Kane Williamson", "Ross Taylor", "Mario Rossi",
        "Giuseppe verdi", "Pippo Baudo",
        "Virat Kohli", "Rohit Sharma", "Steve Smith",
        "Kane Williamson", "Ross Taylor", "Mario Rossi",
        "Giuseppe verdi", "Pippo Baudo")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list_book_frag, container, false)
        view.findViewById<ListView>(R.id.list_view_book).adapter =
            context?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, authors) }
        return view
    }

}