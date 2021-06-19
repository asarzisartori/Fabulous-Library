package com.example.librapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun checkLogin (v: View?) {
      val email = findViewById<EditText>(R.id.username_view).getText().toString()
        val pass = findViewById<EditText>(R.id.password_view).getText().toString()

        if(email.isEmpty()){
            findViewById<EditText>(R.id.username_view).error = getString(R.string.invalid_username)
            return
        }

        if(pass.isEmpty()){
            findViewById<EditText>(R.id.password_view).error = getString(R.string.invalid_password)
            return
        }

        if (!isNotValidEmail(email)) {
            findViewById<EditText>(R.id.username_view).setError(getString(R.string.invalid_email))
            Toast.makeText(applicationContext, "Prova", Toast.LENGTH_SHORT).show()
            return
        }


        if (!isNotValidPassword(pass)) {
            findViewById<EditText>(R.id.password_view).setError(getString(R.string.invalid_password))
            return
        }

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val intentLog = Intent(this@MainActivity, UserLoggedActivity::class.java)
                    startActivity(intentLog)
                    Toast.makeText(applicationContext, "LogInSuccess", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(applicationContext, "ErrorLoggingIn", Toast.LENGTH_LONG).show()
                }

            }
    }

    private fun isNotValidPassword(pass: String): Boolean {
        return if (pass.length >= 8) {
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

    fun openFreeAccess (v: View) {
        val intent = Intent(this@MainActivity, FreeAccessActivity::class.java)
        startActivity(intent)
    }

    fun openSignIn (v: View) {
        val intent = Intent(this@MainActivity, SignInActivity::class.java)
        startActivity(intent)
    }

    fun openAdminSection (v: View) {
        val intent = Intent(this@MainActivity, AdminSectionActivity::class.java)
        startActivity(intent)
    }



}