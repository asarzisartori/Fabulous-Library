package com.example.librapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProductWindowNoLoggedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_window_no_logged)

        val dataTitolo = intent.getStringExtra("Titolo").toString()
        val dataTipologia = intent.getStringExtra("Tipologia").toString()
        FirebaseDatabase.getInstance().getReference("Item").child(dataTipologia).child(dataTitolo).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val i = snapshot.getValue(Item::class.java)
                val titolo = i?.titolo
                val autore = i?.autore
                val tipologia = i?.tipologia
                val descrizione = i?.descrizione
                val genere = i?.genere

                findViewById<TextView>(R.id.TV_Genere).text = genere
                findViewById<TextView>(R.id.TV_Titolo).text = titolo
                findViewById<TextView>(R.id.TV_Autore).text = autore
                findViewById<TextView>(R.id.TV_Tipologia).text = tipologia
                findViewById<TextView>(R.id.TV_Descrizione).text = descrizione
            }

            override fun onCancelled(error: DatabaseError) { }

        })
    }
}