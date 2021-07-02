package com.example.librapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.util.*


class PersonalProfile_frag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_personal_profile_frag, container, false)
        val user = FirebaseAuth.getInstance().currentUser
        val email = user?.email.toString()
        val uid = user?.uid.toString()
        view.findViewById<TextView>(R.id.textView_email).text = email
        val db: DatabaseReference = FirebaseDatabase.getInstance().getReference("Users").child(uid)

        db.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(User::class.java)
                val name = user?.nome.toString()
                val password = user?.password.toString()
                view.findViewById<TextView>(R.id.textView_username).text = name
                view.findViewById<TextView>(R.id.textView_password).text = password
            }

            override fun onCancelled(error: DatabaseError) { }

        })

        val bottone = view.findViewById<Button>(R.id.button_logout)
        bottone.setOnClickListener {
            activity?.finish()
        }

        return view
    }

}