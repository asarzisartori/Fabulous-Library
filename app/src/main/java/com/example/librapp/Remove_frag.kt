package com.example.librapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.firebase.database.FirebaseDatabase

class Remove_frag : Fragment(), AdapterView.OnItemSelectedListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_remove_frag, container, false)
        val list_of_items = arrayOf("Libro", "Audiolibro", "Film", "Scienza")
        val spinner = view?.findViewById<Spinner>(R.id.spinner_typo)
        spinner!!.setOnItemSelectedListener(this)
        spinner.adapter = activity?.let { ArrayAdapter(it, R.layout.support_simple_spinner_dropdown_item, list_of_items) }

        view.findViewById<Button>(R.id.button_RemoveProduct).setOnClickListener {

            val titolo = view.findViewById<EditText>(R.id.titleR).text.toString()
            if (titolo.isEmpty()) {
                view.findViewById<EditText>(R.id.titleR).error = getString(R.string.invalid_title)
                }else {
                FirebaseDatabase.getInstance().getReference("Item").child(getValue()).child(titolo).removeValue().addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(context, "Product removed", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Error removing product", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        return view
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) { }
    override fun onNothingSelected(parent: AdapterView<*>?) { }

    fun getValue(): String {
        var tmp : String = ""
        val confronto = view?.findViewById<Spinner>(R.id.spinner_typo)?.getSelectedItemPosition().toString()
        if (confronto.equals("0")) {
            tmp = "Libro"
        } else {
            if (confronto.equals("1")) {
                tmp = "Audiolibro"
            } else {
                if (confronto.equals("2")) {
                    tmp = "Film"
                } else {
                    if (confronto.equals("3")) {
                        tmp = "Scienza"
                    }
                }
            }
        }

        return tmp
    }

}