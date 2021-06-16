package com.example.librapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.google.firebase.database.*


class List_ciack_frag : Fragment() {

    val TAG = "List_ciak_frag"
    val authors = arrayListOf<String>("Marco Rossi", "Paolo Bianchi", "Paolo, Camera", "Bruto il Corsaro")
    val filmList: MutableList<Item> = ArrayList()
    private val itemAdapter: ItemAdapter = ItemAdapter(this,filmList)
    val mDatabase:DatabaseReference? = FirebaseDatabase.getInstance().getReference("Item")
    var mItemChildListener: ChildEventListener = getItemChildListener()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val iommy = Item("ciao","ciao","ciao","ciao","ciao")
        filmList.add(iommy)

        val view = inflater.inflate(R.layout.fragment_list_ciack_frag, container, false)
        view.findViewById<ListView>(R.id.list_view_ciak).adapter = itemAdapter

        return view
    }

    override fun onStart() {
        super.onStart()
        mDatabase!!.addChildEventListener(mItemChildListener)
    }

    override fun onStop() {
        super.onStop()
        if(mItemChildListener != null)
        mDatabase?.removeEventListener(mItemChildListener)
    }

    private fun getItemChildListener(): ChildEventListener{
        val childEventListener = object: ChildEventListener{
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
            Log.d(TAG,"onChildAdded"+ snapshot.key)
             val newItem = snapshot.getValue(Item::class.java)
             filmList.add(newItem!!)
                itemAdapter.notifyDataSetChanged()
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                TODO("Not yet implemented")
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        }
        return childEventListener
    }

}



