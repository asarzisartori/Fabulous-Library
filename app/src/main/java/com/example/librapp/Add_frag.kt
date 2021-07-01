package com.example.librapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class Add_frag : Fragment(), AdapterView.OnItemSelectedListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_add_frag, container, false)
        val list_of_items = arrayOf("Libro", "Audiolibro", "Film", "Scienza")
        val spinner = view?.findViewById<Spinner>(R.id.spinner_typo)
        spinner!!.setOnItemSelectedListener(this)
        spinner.adapter = activity?.let { ArrayAdapter(it, R.layout.support_simple_spinner_dropdown_item, list_of_items) }

        view.findViewById<Button>(R.id.button_AddProduct).setOnClickListener {

            val item_titolo = view.findViewById<EditText>(R.id.titleA).text.toString()
            val item_autore = view.findViewById<EditText>(R.id.authorA).text.toString()
            val item_genere = view.findViewById<EditText>(R.id.genereA).text.toString()
            var item_tipologia = getValue()
            val item_descrizione = view.findViewById<EditText>(R.id.descriptionA).text.toString()

            if(item_titolo.isEmpty()){
                view.findViewById<EditText>(R.id.titleA).error = getString(R.string.invalid_title)
            } else {
                if (item_autore.isEmpty()) {
                    view.findViewById<EditText>(R.id.authorA).error = getString(R.string.invalid_author)
                } else {
                    if (item_genere.isEmpty()) {
                        view.findViewById<EditText>(R.id.genereA).error = getString(R.string.invalid_genre)
                        } else {
                            if (item_descrizione.isEmpty()) {
                                view.findViewById<EditText>(R.id.descriptionA).error = getString(R.string.invalid_description)
                            } else {
                                    val timestamp = Date().time.toString()
                                    val item = Item(item_titolo, item_autore, item_genere, item_tipologia, item_descrizione, "False", "Nobody", timestamp)
                                    FirebaseDatabase.getInstance().getReference("Item").child(item_tipologia).child(item_titolo).setValue(item).addOnCompleteListener { task ->
                                                if (task.isSuccessful) {
                                                    Toast.makeText(context, "Product successfully uploaded", Toast.LENGTH_SHORT).show()
                                                } else {
                                                    Toast.makeText(context, "Error uploading", Toast.LENGTH_SHORT).show()
                                                }
                                    }
                                }
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