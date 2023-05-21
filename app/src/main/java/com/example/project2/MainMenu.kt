package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)

        var buttonKamar1 = findViewById<View>(R.id.kamar1)
        buttonKamar1.setOnClickListener{
            val intentRoom1 = Intent(this, MainRoom1::class.java)
            startActivity(intentRoom1)
        }
        var buttonKamar2 = findViewById<View>(R.id.kamar2)
        buttonKamar2.setOnClickListener{
            val intentRoom1 = Intent(this, MainRoom1::class.java)
            startActivity(intentRoom1)
        }

        var backtologin = findViewById<View>(R.id.imageView3)
        backtologin.setOnClickListener{
            val intentBack = Intent(this, SignUp::class.java)
            startActivity(intentBack)
        }
    }


}