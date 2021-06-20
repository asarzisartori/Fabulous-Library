package com.example.librapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class PersonalProfile_frag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val user = FirebaseAuth.getInstance().currentUser
        val email = user?.email.toString()
        val uid = user?.uid.toString()
        Toast.makeText(context,email, Toast.LENGTH_SHORT).show()
        Toast.makeText(context,uid, Toast.LENGTH_SHORT).show()
        val db: DatabaseReference = FirebaseDatabase.getInstance().getReference("Users").child(uid)
            db.addValueEventListener(object: ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(User::class.java)
                val name = user?.nome.toString()
                val password = user?.password.toString()
                Toast.makeText(context,name, Toast.LENGTH_SHORT).show()
                Toast.makeText(context,password , Toast.LENGTH_SHORT).show()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })





        return inflater.inflate(R.layout.fragment_personal_profile_frag, container, false)

    }
}