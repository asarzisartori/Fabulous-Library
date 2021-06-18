package com.example.librapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.google.firebase.database.*
import kotlin.collections.ArrayList

class List_book_frag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_list_book_frag, container, false)
        var listView = view.findViewById<ListView>(R.id.list_view_book)
        val datab : FirebaseDatabase = FirebaseDatabase.getInstance()
        val reference : DatabaseReference = datab.getReference("Item/Libro")

        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val itemList : ArrayList<Item> =  ArrayList()
                for( itemSnap : DataSnapshot in snapshot.getChildren()){
                    itemList.add(itemSnap.getValue(Item::class.java)!!)
                }
                val itemAdapter = ItemAdapter(activity, itemList)
                listView.adapter = itemAdapter
            }

            override fun onCancelled(error: DatabaseError) { }

        })

        return view
    }

    override fun onStart() {
        super.onStart()
    }

}