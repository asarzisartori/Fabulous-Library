package com.example.librapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_image_button_frag.*

class FreeAccess : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_free_access)

        fa_book_button.setOnClickListener(this)
        fa_audiobook_button.setOnClickListener(this)
        fa_ciak_button.setOnClickListener(this)
        fa_scientistbook_button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fa_book_button -> textView2.text = "libro"
            R.id.fa_audiobook_button -> textView2.text = "audio"
            R.id.fa_ciak_button -> textView2.text = "chack"
            R.id.fa_scientistbook_button -> textView2.text = "coldplay"
        }
    }
}