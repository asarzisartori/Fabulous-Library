package com.example.librapp

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.util.regex.Pattern

class Sign_In_Activity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin_layout)

    }

    fun Registrate(v: View) {

        val name = findViewById<EditText>(R.id.nameField).getText().toString()
        val email = findViewById<EditText>(R.id.emailField).getText().toString()
        val pass = findViewById<EditText>(R.id.passwordText).getText().toString()

        if(name.isEmpty()){
            findViewById<EditText>(R.id.nameField).setError(getString(R.string.invalid_username))
            return
        }
        if(pass.isEmpty()){
            findViewById<EditText>(R.id.passwordText).setError(getString(R.string.invalid_password))
            return
        }

        if (!isNotValidPassword(pass)) {
            findViewById<EditText>(R.id.passwordText).setError(getString(R.string.invalid_password))
            return
        }

        if(email.isEmpty()) {
            findViewById<EditText>(R.id.emailField).setError(getString(R.string.invalid_email))
            return
        }

        if (!isNotValidEmail(email)) {
            findViewById<EditText>(R.id.emailField).setError(getString(R.string.invalid_email))
            return
        }

        val Users = FirebaseDatabase.getInstance().getReference("Users").child("nome").get()
           if (Users.equals(name)){
               Toast.makeText(applicationContext, "User already exists", Toast.LENGTH_LONG).show()
               return
           }


        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = User(name, email, pass)
                    FirebaseDatabase.getInstance().getReference("Users")
                        .child(FirebaseAuth.getInstance().currentUser?.uid.toString())
                        .setValue(user)


                    Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
                }

            }


    }
    private fun isNotValidPassword(pass: String): Boolean {
        return if (pass != null && pass.length >= 8) { true } else { false }
    }
    private fun isNotValidEmail(email: String): Boolean {
        val EMAIL_PATTERN = ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
        val pattern = Pattern.compile(EMAIL_PATTERN)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }
}
