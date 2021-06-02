package com.example.librapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment


class Image_button_frag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_image_button_frag, container, false)

        view.findViewById<ImageButton>(R.id.fa_book_button).setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container_buttonview, List_book_frag())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }

        view.findViewById<ImageButton>(R.id.fa_audiobook_button).setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container_buttonview, List_audiobook_frag())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }

        view.findViewById<ImageButton>(R.id.fa_ciak_button).setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container_buttonview, List_ciack_frag())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }

        view.findViewById<ImageButton>(R.id.fa_scientistbook_button).setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container_buttonview, List_sciencebook_frag())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }

        return view
    }
}