package com.example.librapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

class List_sciencebook_frag : Fragment() {

    val authors = arrayListOf<String>("Focus", "Focus Junior", "Mistero", "The Whole Earth Catalog")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list_sciencebook_frag, container, false)
        view.findViewById<ListView>(R.id.list_view_sciencebook).adapter =
            context?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, authors) }
        return view
    }

}