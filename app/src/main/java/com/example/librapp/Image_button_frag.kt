package com.example.librapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList


class Image_button_frag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_image_button_frag, container, false)

        val newsListView = view.findViewById<GridView>(R.id.news_list)
        val newslist: ArrayList<Item> = ArrayList()
        val newsAdapter = News_Adapter(activity,newslist)
        val date = (Date().time - TimeUnit.MILLISECONDS.convert(7,TimeUnit.DAYS)).toString()

        FirebaseDatabase.getInstance().getReference("Item/Film").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (itemSnap: DataSnapshot in snapshot.getChildren()){
                    val dummy = itemSnap.getValue(Item::class.java)!!
                    val time = dummy.timestamp
                    if(time > date){
                        newslist.add(dummy)
                    }
                }
                newsListView.adapter = newsAdapter
            }

            override fun onCancelled(error: DatabaseError) { }

        })

        FirebaseDatabase.getInstance().getReference("Item/Libro").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (itemSnap: DataSnapshot in snapshot.getChildren()){
                    val dummy = itemSnap.getValue(Item::class.java)!!
                    val time = dummy.timestamp
                    if(time > date){
                        newslist.add(dummy)
                    }
                }
                newsListView.adapter = newsAdapter
            }

            override fun onCancelled(error: DatabaseError) { }

        })

        FirebaseDatabase.getInstance().getReference("Item/Audiolibro").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (itemSnap: DataSnapshot in snapshot.getChildren()){
                    val dummy = itemSnap.getValue(Item::class.java)!!
                    val time = dummy.timestamp
                    if(time > date){
                        newslist.add(dummy)
                    }
                }
                newsListView.adapter = newsAdapter
            }

            override fun onCancelled(error: DatabaseError) { }

        })

        FirebaseDatabase.getInstance().getReference("Item/Scienza").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (itemSnap: DataSnapshot in snapshot.getChildren()){
                    val dummy = itemSnap.getValue(Item::class.java)!!
                    val time = dummy.timestamp
                    if(time > date){
                        newslist.add(dummy)
                    }
                }
                newsListView.adapter = newsAdapter
            }

            override fun onCancelled(error: DatabaseError) { }

        })

        view.findViewById<ImageButton>(R.id.fa_book_button).setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            if(requireActivity() is FreeAccessActivity) {
                transaction?.replace(R.id.fragment_container_freeaccess, List_book_frag())
            }
            if (requireActivity() is UserLoggedActivity) {
                transaction?.replace(R.id.fragment_container_userlogged, List_book_frag())
            }
            transaction?.addToBackStack(null)?.commit()
        }

        view.findViewById<ImageButton>(R.id.fa_audiobook_button).setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            if(requireActivity() is FreeAccessActivity) {
                transaction?.replace(R.id.fragment_container_freeaccess, List_audiobook_frag())
            }
            if (requireActivity() is UserLoggedActivity) {
                transaction?.replace(R.id.fragment_container_userlogged, List_audiobook_frag())
            }
            transaction?.addToBackStack(null)?.commit()
        }

        view.findViewById<ImageButton>(R.id.fa_ciak_button).setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            if(requireActivity() is FreeAccessActivity) {
                transaction?.replace(R.id.fragment_container_freeaccess, List_ciack_frag())
            }
            if (requireActivity() is UserLoggedActivity) {
                transaction?.replace(R.id.fragment_container_userlogged, List_ciack_frag())
            }
            transaction?.addToBackStack(null)?.commit()
        }

        view.findViewById<ImageButton>(R.id.fa_scientistbook_button).setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            if(requireActivity() is FreeAccessActivity) {
                transaction?.replace(R.id.fragment_container_freeaccess, List_sciencebook_frag())
            }
            if (requireActivity() is UserLoggedActivity) {
                transaction?.replace(R.id.fragment_container_userlogged, List_sciencebook_frag())
            }
            transaction?.addToBackStack(null)?.commit()
        }

        newsListView.setOnItemClickListener { parent: AdapterView<*>?, view: View, position: Int, id: Long ->
            val itemAdapter = ItemAdapter(context,newslist)
            val item = itemAdapter.getItem(position)
            val item_due = itemAdapter.getTipologia(position)
            val intent = Intent(activity, ProductWindowNoLoggedActivity::class.java)
            intent.putExtra("Titolo", item.toString())
            intent.putExtra("Tipologia", item_due.toString())
            startActivity(intent)
        }

        return view
    }
}