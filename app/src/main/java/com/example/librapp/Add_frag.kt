package com.example.librapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class Add_frag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       val view = inflater.inflate(R.layout.fragment_add_frag, container, false)

        view.findViewById<Button>(R.id.button_AddProduct).setOnClickListener {
            Toast.makeText(context, "dio bono", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}