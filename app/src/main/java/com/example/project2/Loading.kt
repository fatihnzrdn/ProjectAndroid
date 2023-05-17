package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Loading : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        Handler().postDelayed({
            var intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }, 5000)
    }
}