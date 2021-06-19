package com.example.librapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ProductWindowLogged_frag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_product_window_logged_frag, container, false)

        val TV_Titolo = view.findViewById<TextView>(R.id.textViewTitolo)
        val TV_Autore = view.findViewById<TextView>(R.id.textViewAutore)
        val TV_Descrizione = view.findViewById<TextView>(R.id.textViewDescrizione)
        val Button_prenota = view.findViewById<Button>(R.id.button_Prenota)

        Button_prenota.setOnClickListener {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }

        //showare su TV_Titolo (TextView_Titolo) il titolo preso dal DB del prodotto selezionato
        //showare su TV_Autore l'autore preso dal DB del prodotto selezionato
        //showare su TV_Descrizione la descrizione preso dal DB del prodotto selezionato
        //bindare con Button_prenota il prodotto selezionato

        return view
    }
}