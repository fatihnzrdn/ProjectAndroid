package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

class successSignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_sign_up)
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({
            finish()
        }, 5000)
    }
}