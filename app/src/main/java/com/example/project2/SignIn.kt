package com.example.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SignIn : AppCompatActivity() {

    lateinit var ref:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in)
        ref = FirebaseDatabase.getInstance().getReference("USER")
        var SignInButton = findViewById<Button>(R.id.button)
        SignInButton.setOnClickListener{
            if((findViewById<EditText>(R.id.emailText).text.toString().isEmpty()) && (findViewById<EditText>(R.id.passwordText).text.toString().isEmpty())){
                findViewById<EditText>(R.id.emailText).error = "Please enter email"
                return@setOnClickListener
            } else {
                saveData()
                //var intent = Intent(this, MainMenu::class.java)
                //startActivity(intent)
            }

        }
    }
    private fun saveData (){
        var email = findViewById<EditText>(R.id.emailText)
        var pass = findViewById<EditText>(R.id.passwordText)
        val email1 = email.text.toString()
        val pass1 = pass.text.toString()
        val userId = ref.push().key.toString()

        val user = Users(userId, email1, pass1)

        ref.child(userId).setValue(user).addOnCompleteListener {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            email.setText("")
            pass.setText("")
        }
    }
}