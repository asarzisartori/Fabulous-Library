package com.example.librapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace


class UserLoggedActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private val list_of_items = arrayOf("Home", "Profile", "Booking List")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userloggedactivity)

        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner!!.setOnItemSelectedListener(this)
        val array_adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list_of_items)
        array_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner!!.setAdapter(array_adapter)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (position) {
            0 -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    addToBackStack(null)
                    replace<Image_button_frag>(R.id.fragment_container_userlogged)
                }
            }

            1 -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    addToBackStack(null)
                    replace<PersonalProfile_frag>(R.id.fragment_container_userlogged)
                }
            }

            2 -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    addToBackStack(null)
                    replace<Booked_frag>(R.id.fragment_container_userlogged)
                }
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) { }
}