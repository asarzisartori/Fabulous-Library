package com.example.librapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class News_Adapter(private val context: Context?, val data: ArrayList<Item>) : BaseAdapter() {
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position].titolo
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var newView = convertView
        if (convertView == null)
            newView = LayoutInflater.from(context).inflate(R.layout.news_adapter, parent, false)

        if (newView != null) {
            val itemTitolo = newView.findViewById<TextView>(R.id.new_titolo)
            val itemTipologia = newView.findViewById<TextView>(R.id.new_tipo)

            itemTitolo.text = data[position].titolo
            itemTipologia.text = data[position].tipologia

        }

        return newView
    }

}