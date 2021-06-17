package com.example.librapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment


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
        val lv = view.findViewById<ListView>(R.id.list_view_book)
        lv.adapter = context?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, authors) }

        lv.setOnItemClickListener { adattatore, componente, pos, id ->
            val titoloriga = adattatore.getItemAtPosition(pos) as String
            Toast.makeText(context, "E' stato cliccato " + titoloriga, Toast.LENGTH_SHORT).show()
        }

        return view
    }
}