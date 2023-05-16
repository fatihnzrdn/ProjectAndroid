package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView

class MainRoom1 : AppCompatActivity() {

    private lateinit var mqttClient: MQTT
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room1)

        mqttClient = MQTT()
        mqttClient.connectBroker(applicationContext)

        var BackButton = findViewById<ImageView>(R.id.backToMenu)
        BackButton.setOnClickListener{
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }

    }

    fun switchLamp(Android: android.view.View){
        var text = findViewById<TextView>(R.id.textView)
        var switchLampu = findViewById<Switch>(R.id.switchLamp)
        switchLampu.setOnClickListener{
            if(switchLampu.isChecked){
                text.setText("ON")
                mqttClient.sendMessage("1")
            } else{
                text.setText("OFF")
            }
        }
    }
}


