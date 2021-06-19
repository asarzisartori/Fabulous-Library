package com.example.librapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ProductWindowNoLogged_frag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_product_window_no_logged_frag, container, false)

        val TV_Titolo = view.findViewById<TextView>(R.id.textViewTitolo)
        val TV_Autore = view.findViewById<TextView>(R.id.textViewAutore)
        val TV_Descrizione = view.findViewById<TextView>(R.id.textViewDescrizione)

        //showare su TV_Titolo (TextView_Titolo) il titolo preso dal DB del prodotto selezionato
        //showare su TV_Autore l'autore preso dal DB del prodotto selezionato
        //showare su TV_Descrizione la descrizione preso dal DB del prodotto selezionato

        return view
    }
}