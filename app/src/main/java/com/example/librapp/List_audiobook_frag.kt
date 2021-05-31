package com.example.librapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

class List_audiobook_frag : Fragment() {

    val authors = arrayListOf<String>("Pomello", "Ale Cervini", "Ghingu", "Pesetti", "Andre")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list_audiobook_frag, container, false)
        view.findViewById<ListView>(R.id.list_view_audiobook).adapter =
            context?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, authors) }
        return view
    }

}