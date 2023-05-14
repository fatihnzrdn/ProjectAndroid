package com.example.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var mqttClient: MQTT
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mqttClient = MQTT()
        mqttClient.connectBroker(applicationContext)

    }

    fun switchLamp(Android: android.view.View){
        var text = findViewById<TextView>(R.id.textView)
        var switchLampu = findViewById<Switch>(R.id.switch1)
        switchLampu.setOnClickListener{
            if(switchLampu.isChecked){
                text.setText("ON")
                mqttClient.sendMessage("1")
            } else{
                text.setText("OFF")
                mqttClient.sendMessage("0")
            }
        }
    }
}


