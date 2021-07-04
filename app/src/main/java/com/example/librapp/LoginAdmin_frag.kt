package com.example.librapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class LoginAdmin_frag : Fragment() {

    override fun onCreateView (inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login_admin_frag, container, false)

        view.findViewById<Button>(R.id.button_adminLogin).setOnClickListener {
            val username = view.findViewById<EditText>(R.id.username_adminView).text.toString()
            val password = view.findViewById<EditText>(R.id.password_adminView).text.toString()
            if (username == "admin" && password == "password") {
                val transaction = activity?.supportFragmentManager?.beginTransaction()
                transaction?.replace(R.id.fragment_container_admin, WorkTableAdmin_frag())
                transaction?.addToBackStack(null)?.commit()
                Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

}