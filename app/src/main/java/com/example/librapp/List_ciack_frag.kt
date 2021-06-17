package com.example.librapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.google.firebase.database.*
import kotlin.collections.ArrayList


class List_ciack_frag : Fragment() {

    val TAG = "List_ciak_frag"
    val authors = arrayListOf<String>("Marco Rossi", "Paolo Bianchi", "Paolo, Camera", "Bruto il Corsaro")
    val filmList: MutableList<Item> = ArrayList()

    //private val itemAdapter: ItemAdapter = ItemAdapter(context,filmList)
    //var mItemChildListener: ChildEventListener = getItemChildListener()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //val iommy = Item("ciao","ciao","ciao","ciao","ciao")
        //filmList.add(iommy)

        val view = inflater.inflate(R.layout.fragment_list_ciack_frag, container, false)
        var listView = view.findViewById<ListView>(R.id.list_view_ciak)
        val datab : FirebaseDatabase = FirebaseDatabase.getInstance()
        val reference : DatabaseReference = datab.getReference("Item/Film")

        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val itemList : ArrayList<Item> =  ArrayList()
                for( itemSnap : DataSnapshot  in snapshot.getChildren()){
                    itemList.add(itemSnap.getValue(Item::class.java)!!)
                }
                val itemAdapter : ItemAdapter = ItemAdapter(activity, itemList)
                listView.adapter = itemAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })


       // view.findViewById<ListView>(R.id.list_view_ciak).adapter = itemAdapter

        return view
    }

    override fun onStart() {
        super.onStart()

        //val mDatabase:DatabaseReference? = FirebaseDatabase.getInstance().getReference("Item")
        //mDatabase!!.addChildEventListener(mItemChildListener)
    }

    //override fun onStop() {
      //  super.onStop()
      //  if(mItemChildListener != null)
      //  mDatabase?.removeEventListener(mItemChildListener)
    //}

   /* private fun getItemChildListener(): ChildEventListener{
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
    }*/

}





