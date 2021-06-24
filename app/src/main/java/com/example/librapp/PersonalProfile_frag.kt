package com.example.librapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class PersonalProfile_frag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_personal_profile_frag, container, false)
        val user = FirebaseAuth.getInstance().currentUser
        val email = user?.email.toString()
        val uid = user?.uid.toString()
        view.findViewById<TextView>(R.id.textEmail).text = email
        Toast.makeText(context,uid, Toast.LENGTH_SHORT).show()
        val db: DatabaseReference = FirebaseDatabase.getInstance().getReference("Users").child(uid)
        val ciao = FirebaseAuth.getInstance().firebaseAuthSettings.toString()
        view.findViewById<TextView>(R.id.textView5).text = ciao

        db.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(User::class.java)
                val name = user?.nome.toString()
                val password = user?.password.toString()
                view.findViewById<TextView>(R.id.textUsername).text = name
                view.findViewById<TextView>(R.id.textPassword).text = password
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        return view
    }
}