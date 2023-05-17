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
            val intentRoom1 = Intent(this, MainRoom1::class.java)
            startActivity(intentRoom1)
        }

        var backtologin = findViewById<View>(R.id.imageView3)
        backtologin.setOnClickListener{
            val intentBack = Intent(this, SignIn::class.java)
            startActivity(intentBack)
        }
    }


}