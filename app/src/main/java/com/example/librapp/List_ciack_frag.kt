package com.example.librapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

class List_ciack_frag : Fragment() {

    val authors = arrayListOf<String>("Marco Rossi", "Paolo Bianchi", "Paolo, Camera", "Bruto il Corsaro")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list_ciack_frag, container, false)
        view.findViewById<ListView>(R.id.list_view_ciak).adapter =
            context?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, authors) }
        return view
    }

}
