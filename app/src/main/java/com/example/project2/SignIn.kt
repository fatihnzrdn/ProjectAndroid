package com.example.project2

import android.content.Intent
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

        var SignUpButton = findViewById<Button>(R.id.button)
        SignUpButton.setOnClickListener{
            if(findViewById<EditText>(R.id.emailText).text.toString().isEmpty()){
                findViewById<EditText>(R.id.emailText).error = "Please enter email"
                return@setOnClickListener
            } else if (findViewById<EditText>(R.id.passwordText).text.toString().isEmpty()) {
                findViewById<EditText>(R.id.passwordText).error = "Please enter password"
                return@setOnClickListener
            } else {
                saveData()
                //var intent = Intent(this, MainMenu::class.java)
                //startActivity(intent)
            }

        }

        var SignInButton = findViewById<Button>(R.id.button2)
        SignInButton.setOnClickListener{
            if(findViewById<EditText>(R.id.emailText2).text.toString().isEmpty()){
                findViewById<EditText>(R.id.emailText2).error = "Please enter email"
                return@setOnClickListener
            } else if (findViewById<EditText>(R.id.passwordText2).text.toString().isEmpty()) {
                findViewById<EditText>(R.id.passwordText2).error = "Please enter password"
                return@setOnClickListener
            } else {
                readData()
            }
        }
    }
    var email = findViewById<EditText>(R.id.emailText)
    var pass = findViewById<EditText>(R.id.passwordText)
    val email1 = email.text.toString()
    val pass1 = pass.text.toString()
    val userId = ref.push().key.toString()

    fun saveData (){


        val user = Users(userId, email1, pass1)

        ref.child(userId).setValue(user).addOnCompleteListener {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            email.setText("")
            pass.setText("")
        }
    }

    fun readData (){

        val user = Users(userId, email1, pass1)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for (h in snapshot.children){
                        val user = h.getValue(Users::class.java)
                        if (user!!.email != email1 && user!!.pass != pass1){
                            Toast.makeText(this@SignIn, "Success", Toast.LENGTH_SHORT).show()
                            email.setText("")
                            pass.setText("")
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@SignIn, "Error", Toast.LENGTH_SHORT).show()
            }

        })
    }
}