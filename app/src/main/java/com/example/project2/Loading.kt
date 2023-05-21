package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast

class Loading : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }, 5000)
    }
}