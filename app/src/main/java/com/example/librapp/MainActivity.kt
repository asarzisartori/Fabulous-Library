package com.example.librapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun checkLogin (v: View?) {
        val email = username_view.getText().toString()
        if (!isNotValidEmail(email)) {
            username_view.setError(getString(R.string.invalid_email))
            Toast.makeText(applicationContext, "Pommerda", Toast.LENGTH_SHORT).show()
        }

        val pass = password_view.getText().toString()
        if (!isNotValidPassword(pass)) {
            password_view.setError(getString(R.string.invalid_password))
        }
    }

    private fun isNotValidPassword(pass: String): Boolean {
        return if (pass != null && pass.length >= 8) {
            true
        } else {
            false
        }
    }

    private fun isNotValidEmail(email: String): Boolean {
        val EMAIL_PATTERN = ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
        val pattern = Pattern.compile(EMAIL_PATTERN)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun openFreeAccess(v: View){
        val intent = Intent(this@MainActivity, FreeAccess::class.java)
        startActivity(intent)
    }

}