package com.example.project2

import android.content.Context
import android.util.Log
import org.eclipse.paho.android.service.MqttAndroidClient
import org.eclipse.paho.client.mqttv3.IMqttActionListener
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.IMqttToken
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttException
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence

class MQTT {
    private val brokerUrl = "tcp://test.mosquitto.org:1883"
    private val topic = "Project/rfid/user/idcard"
    private val qos = 0
    private val clientId = "myJavaClient"
    private val persistence = MemoryPersistence()

    fun receiveMessages(): String {
        var messageCard = ""
        try {
            val mqttClient = MqttClient(brokerUrl, clientId, persistence)
            mqttClient.setCallback(object : MqttCallback {
                override fun connectionLost(cause: Throwable?) {
                    println("Connection lost: " + cause?.message)
                }

                @Throws(Exception::class)
                override fun messageArrived(topic: String?, message: MqttMessage?) {
                    println("MQTT message received: " + message?.toString())

                }

                override fun deliveryComplete(token: IMqttDeliveryToken?) {
                    // Not used in this example
                }
            })

            mqttClient.connect()
            mqttClient.subscribe(topic, qos)
        } catch (e: MqttException) {
            println("Error: " + e.message)
        }
        return messageCard
    }

    fun sendMessage(topic: String, message: String) {
        try {
            val mqttClient = MqttClient(brokerUrl, clientId, persistence)
            mqttClient.connect()
            val mqttMessage = MqttMessage()
            mqttMessage.payload = message.toByteArray()
            mqttClient.publish(topic, mqttMessage)
            println("message published : $message with topic $topic")
            mqttClient.disconnect()
        } catch (e: MqttException) {
            println("Error sending message: " + e.message)
        }
    }


}