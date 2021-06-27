package com.example.librapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class Remove_frag : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_remove_frag, container, false)

        view.findViewById<Button>(R.id.button_RemoveProduct).setOnClickListener {
            val titolo = view.findViewById<EditText>(R.id.titleR).text.toString()
            val tipologia = view.findViewById<EditText>(R.id.tipoR).text.toString()
            if (titolo.isEmpty()){
                view.findViewById<EditText>(R.id.titleR).error = "Titolo non valido"
            }else{
                if(tipologia.isEmpty()){
                    view.findViewById<EditText>(R.id.tipoR).error = "Tipologia non valida"
                }else{
                    FirebaseDatabase.getInstance().getReference("Item").child(tipologia).child(titolo).removeValue().addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            view.findViewById<EditText>(R.id.titleR).error = "Rimosso"
                        } else {
                            view.findViewById<EditText>(R.id.titleR).error = "Pippo"
                        }

                    }
                }
            }

        }

        return view
    }
}
