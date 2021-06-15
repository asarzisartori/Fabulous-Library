package com.example.librapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.firebase.database.*

class List_ciack_frag : Fragment() {

    val authors = arrayListOf<String>("Marco Rossi", "Paolo Bianchi", "Paolo, Camera", "Bruto il Corsaro")
     val FilmList = arrayListOf<String>("Iommy")
    val mDatabase:DatabaseReference? = FirebaseDatabase.getInstance().getReference("Item")



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list_ciack_frag, container, false)
        view.findViewById<ListView>(R.id.list_view_ciak).adapter =
            context?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, FilmList) }
        return view
    }

    override fun onStart() {
        super.onStart()
        mDatabase!!.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val newItem = snapshot.getValue(Item::class.java).toString()
                FilmList.add(newItem!!)






            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

}



