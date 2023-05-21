package com.example.project2

import android.util.Log
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class userData {
    private lateinit var ref:DatabaseReference

    fun saveData(inputEmail: String, inputPassword: String){
        ref = FirebaseDatabase.getInstance().getReference("USER")
        val userID = ref.push().key.toString()
        val user = Users(userID, inputEmail, inputPassword)
        ref.child(userID).setValue(user).addOnCompleteListener{
            Log.d ("SignUp", "Success")
        }
    }

    fun readData(inputEmail: String, inputPassword: String){
        ref = FirebaseDatabase.getInstance().getReference("USER")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for (userSnapshot in snapshot.children){
                        val user = userSnapshot.getValue(Users::class.java)
                        if (user != null) {
                            if (user.email == inputEmail && user.pass == inputPassword){
                                Log.d("SignIn", "Success")
                            }
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("SignIn", "Error")
            }
        })
    }


}