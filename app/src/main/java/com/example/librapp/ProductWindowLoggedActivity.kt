package com.example.librapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProductWindowLoggedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_window_logged)

        val dataTitolo = intent.getStringExtra("Titolo").toString()
        val uid = FirebaseAuth.getInstance().currentUser?.uid.toString()
        val dataTipologia = intent.getStringExtra("Tipologia").toString()
        FirebaseDatabase.getInstance().getReference("Item").child(dataTipologia).child(dataTitolo).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val i = snapshot.getValue(Item::class.java)
                val titolo = i?.titolo
                val autore = i?.autore
                val genere = i?.genere
                val tipologia = i?.tipologia
                val descrizione = i?.descrizione
                var prenotato_state = ""

                if ((i?.prenotato).equals("True")) {
                    prenotato_state = "Not Available"
                }  else {
                    prenotato_state = "Available"
                }

                val check = findViewById<TextView>(R.id.textView_State)
                check.text = prenotato_state
                if (prenotato_state.equals("Not Available")) {
                    check.setTextColor(Color.RED)
                } else {
                    check.setTextColor(Color.GREEN)
                }

                findViewById<TextView>(R.id.TV_Genere).text = genere
                findViewById<TextView>(R.id.TV_Titolo).text = titolo
                findViewById<TextView>(R.id.TV_Autore).text = autore
                findViewById<TextView>(R.id.TV_Tipologia).text = tipologia
                findViewById<TextView>(R.id.TV_Descrizione).text = descrizione
            }

            override fun onCancelled(error: DatabaseError) { }

        })

        findViewById<Button>(R.id.button_Prenota).setOnClickListener {
            FirebaseDatabase.getInstance().getReference("Item").child(dataTipologia).child(dataTitolo).addListenerForSingleValueEvent(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val itemprenotato = snapshot.getValue(Item::class.java)
                    val prenotato = itemprenotato?.prenotato.toString()
                    if (prenotato == "False") {
                        FirebaseDatabase.getInstance().getReference("Item").child(dataTipologia).child(dataTitolo).child("prenotato").setValue("True")
                        FirebaseDatabase.getInstance().getReference("Item").child(dataTipologia).child(dataTitolo).child("user").setValue(uid)
                        Toast.makeText(applicationContext, "Product succesfully booked", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(applicationContext, "Product is no longer available", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onCancelled(error: DatabaseError) { }

            })
        }

        findViewById<Button>(R.id.button_Restituisci).setOnClickListener {
            FirebaseDatabase.getInstance().getReference("Item").child(dataTipologia).child(dataTitolo).addListenerForSingleValueEvent(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val itemprenotato = snapshot.getValue(Item::class.java)
                    val useritem = itemprenotato?.user.toString()
                    if (useritem == uid) {
                        FirebaseDatabase.getInstance().getReference("Item").child(dataTipologia).child(dataTitolo).child("prenotato").setValue("False")
                        FirebaseDatabase.getInstance().getReference("Item").child(dataTipologia).child(dataTitolo).child("user").setValue("Nobody")
                        Toast.makeText(applicationContext, "Restitution success", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(applicationContext, "Product is not in your booking list", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onCancelled(error: DatabaseError) { }

            })
        }
    }

}