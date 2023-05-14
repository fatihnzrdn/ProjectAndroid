package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)

        var buttonKamar = findViewById<View>(R.id.kamar1)
        buttonKamar.setOnClickListener{
            val intent = Intent(this, MainRoom1::class.java)
            startActivity(intent)
        }

    }


}