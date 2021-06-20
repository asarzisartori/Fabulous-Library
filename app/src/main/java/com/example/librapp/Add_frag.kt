package com.example.librapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class Add_frag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       val view = inflater.inflate(R.layout.fragment_add_frag, container, false)

        view.findViewById<Button>(R.id.button_AddProduct).setOnClickListener {
            val titolo = view.findViewById<EditText>(R.id.titleA).text.toString()
            val autore = view.findViewById<EditText>(R.id.authorA).text.toString()
            val genere = view.findViewById<EditText>(R.id.genereA).text.toString()
            val tipologia = view.findViewById<EditText>(R.id.typoA).text.toString()
            val descrizione = view.findViewById<EditText>(R.id.descriptionA).text.toString()
            if(titolo.isEmpty()){
                view.findViewById<EditText>(R.id.titleA).error = getString(R.string.invalid_username)

            } else {
                if (autore.isEmpty()) {
                    view.findViewById<EditText>(R.id.authorA).error =
                        getString(R.string.invalid_username)
                }else {
                    if (genere.isEmpty()) {
                        view.findViewById<EditText>(R.id.genereA).error =
                            getString(R.string.invalid_username)
                    }else {
                        if (tipologia.isEmpty()) {
                            view.findViewById<EditText>(R.id.typoA).error =
                                getString(R.string.invalid_username)
                        } else {
                            if (descrizione.isEmpty()) {
                                view.findViewById<EditText>(R.id.descriptionA).error =
                                    getString(R.string.invalid_username)
                            }else {
                                val item = Item(titolo, autore, genere, tipologia, descrizione,"False","Nobody")
                                FirebaseDatabase.getInstance().getReference("Item").child(tipologia).child(titolo)
                                    .setValue(item)
                                    .addOnCompleteListener { task ->
                                        if (task.isSuccessful) {
                                            Toast.makeText(
                                                context,
                                                "Item Successfully uploaded",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        } else {
                                            Toast.makeText(context, "Error", Toast.LENGTH_SHORT)
                                                .show()
                                        }

                                    }
                            }
                            }
                        }
                }
                }
            }

        return view
    }
}