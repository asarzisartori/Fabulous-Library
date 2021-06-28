package com.example.librapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class Booked_frag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val uid = FirebaseAuth.getInstance().currentUser?.uid.toString()
        val view = inflater.inflate(R.layout.fragment_booked_frag, container, false)
        var listView = view.findViewById<ListView>(R.id.listview_Booked)
        val itemList: ArrayList<Item> = ArrayList()
        val itemAdapter = ItemAdapter(activity, itemList)

        FirebaseDatabase.getInstance().getReference("Item/Film").orderByChild("user").equalTo(uid).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (itemSnap: DataSnapshot in snapshot.getChildren()) {
                    itemList.add(itemSnap.getValue(Item::class.java)!!)
                }
                listView.adapter = itemAdapter
            }

            override fun onCancelled(error: DatabaseError) { }

        })

        FirebaseDatabase.getInstance().getReference("Item/Scienza").orderByChild("user").equalTo(uid).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (itemSnap: DataSnapshot in snapshot.getChildren()) {
                    itemList.add(itemSnap.getValue(Item::class.java)!!)
                }
                listView.adapter = itemAdapter
            }

            override fun onCancelled(error: DatabaseError) { }

        })

        FirebaseDatabase.getInstance().getReference("Item/Libro").orderByChild("user").equalTo(uid).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (itemSnap: DataSnapshot in snapshot.getChildren()) {
                    itemList.add(itemSnap.getValue(Item::class.java)!!)
                }
                listView.adapter = itemAdapter
            }

            override fun onCancelled(error: DatabaseError) { }

        })

        FirebaseDatabase.getInstance().getReference("Item/Audiolibro").orderByChild("user").equalTo(uid).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (itemSnap: DataSnapshot in snapshot.getChildren()) {
                    itemList.add(itemSnap.getValue(Item::class.java)!!)
                }
                listView.adapter = itemAdapter
            }

            override fun onCancelled(error: DatabaseError) { }

        })

        return view
    }
}