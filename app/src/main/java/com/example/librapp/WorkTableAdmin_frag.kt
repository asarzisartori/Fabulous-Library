package com.example.librapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class WorkTableAdmin_frag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_work_table_admin_frag, container, false)

        view.findViewById<Button>(R.id.button_Add).setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container_add_remove, Add_frag())
            transaction?.commit()
        }

        view.findViewById<Button>(R.id.button_Remove).setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container_add_remove, Remove_frag())
            transaction?.commit()
        }

        return view
    }

}