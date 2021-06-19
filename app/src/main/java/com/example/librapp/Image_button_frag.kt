package com.example.librapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment


class Image_button_frag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_image_button_frag, container, false)

        view.findViewById<ImageButton>(R.id.fa_book_button).setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            if(requireActivity() is FreeAccessActivity) {
                transaction?.replace(R.id.fragment_container_freeaccess, List_book_frag())
            }
            if (requireActivity() is UserLoggedActivity) {
                transaction?.replace(R.id.fragment_container_userlogged, List_book_frag())
            }
            transaction?.commit()
        }

        view.findViewById<ImageButton>(R.id.fa_audiobook_button).setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            if(requireActivity() is FreeAccessActivity) {
                transaction?.replace(R.id.fragment_container_freeaccess, List_audiobook_frag())
            }
            if (requireActivity() is UserLoggedActivity) {
                transaction?.replace(R.id.fragment_container_userlogged, List_audiobook_frag())
            }
            transaction?.commit()
        }

        view.findViewById<ImageButton>(R.id.fa_ciak_button).setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            if(requireActivity() is FreeAccessActivity) {
                transaction?.replace(R.id.fragment_container_freeaccess, List_ciack_frag())
            }
            if (requireActivity() is UserLoggedActivity) {
                transaction?.replace(R.id.fragment_container_userlogged, List_ciack_frag())
            }
            transaction?.commit()
        }

        view.findViewById<ImageButton>(R.id.fa_scientistbook_button).setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            if(requireActivity() is FreeAccessActivity) {
                transaction?.replace(R.id.fragment_container_freeaccess, List_sciencebook_frag())
            }
            if (requireActivity() is UserLoggedActivity) {
                transaction?.replace(R.id.fragment_container_userlogged, List_sciencebook_frag())
            }
            transaction?.commit()
        }

        view.findViewById<Button>(R.id.button_Back).setOnClickListener {
            requireActivity().onBackPressed()
        }

        return view
    }
}