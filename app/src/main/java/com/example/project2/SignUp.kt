package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.EditText
import android.widget.Toast

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }
    val userData = userData()


    fun signUpButton(Android: android.view.View){
        val email1 = findViewById<EditText>(R.id.emailText)
        val password1 = findViewById<EditText>(R.id.passwordText)

        val email = findViewById<EditText>(R.id.emailText).text.toString()
        val password = findViewById<EditText>(R.id.passwordText).text.toString()

        if (email.isEmpty()){
            findViewById<EditText>(R.id.emailText).error = "Please enter email"
            return
        } else if (password.isEmpty()){
            findViewById<EditText>(R.id.passwordText).error = "Please enter password"
            return
        } else {
            userData.saveData(email, password)
            email1.setText("")
            password1.setText("")
            Handler().postDelayed({
                val intent = Intent(this, successSignUp::class.java)
                startActivity(intent)
            }, 1000)
        }
    }

    fun signInButton(Android: android.view.View){
        val email = findViewById<EditText>(R.id.emailText).text.toString()
        val password = findViewById<EditText>(R.id.passwordText).text.toString()

        if (email.isEmpty()){
            findViewById<EditText>(R.id.emailText).error = "Please enter email"
            return
        } else if (password.isEmpty()){
            findViewById<EditText>(R.id.passwordText).error = "Please enter password"
            return
        } else {
            val intent = Intent(this, Loading::class.java)
            startActivity(intent)
        }
    }
}
